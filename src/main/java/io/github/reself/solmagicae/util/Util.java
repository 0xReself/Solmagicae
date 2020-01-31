package io.github.reself.solmagicae.util;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Util {
	
	public static TileEntity getExistingTileEntity(World world, BlockPos pos)
	{
		if(world != null && world.isBlockLoaded(pos))
			return world.getTileEntity(pos);
		return null;
	}
}