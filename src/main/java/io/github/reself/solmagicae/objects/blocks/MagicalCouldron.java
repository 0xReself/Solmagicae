package io.github.reself.solmagicae.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MagicalCouldron extends BlockBase{
	
	//the first 3 how much in ( in() / 16 ) the other size
	public static final AxisAlignedBB MAGICAL_COULDRON_AABB = new AxisAlignedBB(0.1875d, 0.1875d, 0.1875d, 0.8125d, 0.8125d, 0.8125d);
	
	public MagicalCouldron() {
		super("magical_couldron", Material.CLOTH);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity)
	{
		entity.setRotationYawHead(60);
	}

	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return MAGICAL_COULDRON_AABB;
	}
}
