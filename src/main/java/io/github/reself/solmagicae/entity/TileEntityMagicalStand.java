package io.github.reself.solmagicae.entity;

import io.github.reself.solmagicae.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityMagicalStand extends TileEntity implements ITickable {
	
	private ItemStack stack = ItemStack.EMPTY;

	public ItemStack getStack() {
	    return stack;
	}
	
	public void setStack(ItemStack stack) {
	    this.stack = stack;
	    markDirty();
	    if (world != null) {
	        IBlockState state = world.getBlockState(getPos());
	        world.notifyBlockUpdate(getPos(), state, state, 2);
	    }
	}
	
	public TileEntityMagicalStand() {
		
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		stack = new ItemStack(compound.getCompoundTag("stack"));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagCompound tagCompound = new NBTTagCompound();
		stack.writeToNBT(tagCompound);
		compound.setTag("stack", tagCompound);
		return compound;
	}

	@Override
	public void update() {
		Reference.LOGGER.info(stack.getDisplayName());
	}
}
