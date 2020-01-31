package io.github.reself.solmagicae.entity;

import io.github.reself.solmagicae.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntitySolarArray extends TileEntity implements ITickable{
	
	public TileEntitySolarController controller;
	private int cooldown;
	public boolean isEmpty = true;
	
	public TileEntitySolarArray() {
		
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}
	
	
	
	public void onBreak() {
		if(controller != null) {			
			controller.isConstructValid();
		}
	}
	
	@Override
	public void update() {
		if(controller != null) {
			//Reference.LOGGER.info("sa " + controller.constructValid + " " + pos);
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		cooldown = compound.getInteger("cooldown");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("cooldown", cooldown);
		return compound;
	}
}