package io.github.reself.solmagicae.entity;

import java.util.ArrayList;
import java.util.List;

import io.github.reself.solmagicae.util.Reference;
import io.github.reself.solmagicae.util.Util;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntitySolarController extends TileEntity implements ITickable {

	private ItemStackHandler handler;
	public boolean constructValid;
	public int cooldown;

	public TileEntitySolarController() {
		this.handler = new ItemStackHandler(9);
		this.constructValid = false;
	}
	
	public void isConstructValid() {
		List<BlockPos> positionToCheck = new ArrayList<BlockPos>();
		positionToCheck.add(this.getPos().add(1, 0, 0));
		positionToCheck.add(this.getPos().add(-1, 0, 0));
		positionToCheck.add(this.getPos().add(0, 0, 1));
		positionToCheck.add(this.getPos().add(0, 0, -1));
		positionToCheck.add(this.getPos().add(1, 0, 1));
		positionToCheck.add(this.getPos().add(1, 0, -1));
		positionToCheck.add(this.getPos().add(-1, 0, 1));
		positionToCheck.add(this.getPos().add(-1, 0, -1));
		
		for(int i = 0; i < positionToCheck.size(); i++) {
			Reference.LOGGER.info(i + " " + world.getBlockState(positionToCheck.get(i)).getBlock().getUnlocalizedName());
			if(!world.getBlockState(positionToCheck.get(i)).getBlock().getUnlocalizedName().equals("tile.solmagicae.solar_array")) {
				constructValid = false;
				Reference.LOGGER.info(constructValid);
				return;
			}	
		}
		
		constructValid = true;
		
		for (int i = 0; i < positionToCheck.size(); i++) {
			TileEntitySolarArray entity = (TileEntitySolarArray)Util.getExistingTileEntity(world, positionToCheck.get(i));
			if(entity != null) {
				entity.controller = this;
			}
		}
		return;
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}
	
	
	@Override
	public void update() {
		if(cooldown < 20) {
			cooldown++;
			return;
		}
		
		cooldown = 0;
		if(constructValid) {			
			handler.insertItem(0, new ItemStack(Items.DIAMOND, 1), false);
		}
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return (T) this.handler;
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		constructValid = compound.getBoolean("constructValid");
		handler.deserializeNBT(compound.getCompoundTag(("ItemStackHandler")));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean("constructValid", constructValid);
		compound.setTag("ItemStackHandler", handler.serializeNBT());
		return compound;
	}

}
