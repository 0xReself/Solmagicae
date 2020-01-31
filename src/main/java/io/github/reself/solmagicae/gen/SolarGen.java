package io.github.reself.solmagicae.gen;

import java.util.Random;

import io.github.reself.solmagicae.init.BlockInit;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class SolarGen implements IWorldGenerator{
	
	public SolarGen()
	{
		
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(random.nextInt(10) == 0)
		{
			int x = chunkX * 16 + random.nextInt(16);
			int z = chunkZ * 16 + random.nextInt(16);
			int y = world.getHeight(x, z);
			generateCouldron(world, x, y, z);
		}
	}
	
	private void generateCouldron(World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		if(world.getBiome(pos) != Biomes.OCEAN && world.getBiome(pos) != Biomes.DEEP_OCEAN && world.getBiome(pos) != Biomes.RIVER && world.getBiome(pos) != Biomes.BEACH)
		{
			if(world.getBlockState(pos.add(new Vec3i(0, -1, 0))).getBlock() != Blocks.LEAVES)
			{
				world.setBlockState(pos, BlockInit.MAGICAL_COULDRON.getDefaultState());
			}		
		}	
	}
}