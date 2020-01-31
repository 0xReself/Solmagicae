package io.github.reself.solmagicae.init;

import java.util.ArrayList;
import java.util.List;

import io.github.reself.solmagicae.objects.blocks.BaseLens;
import io.github.reself.solmagicae.objects.blocks.BlockBase;
import io.github.reself.solmagicae.objects.blocks.BlockMagicalStand;
import io.github.reself.solmagicae.objects.blocks.BlockSolarController;
import io.github.reself.solmagicae.objects.blocks.MagicalCouldron;
import io.github.reself.solmagicae.objects.blocks.SolarArrayTile;
import net.minecraft.block.Block;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block MAGICAL_COULDRON = new MagicalCouldron();
	public static final Block SOLARARRAY_TILE = new SolarArrayTile();
	public static final Block IRON_LENS = new BaseLens("iron_lens");
	public static final Block COAL_LENS = new BaseLens("coal_lens");
	public static final Block SOLAR_CONTROLLER = new BlockSolarController();
	public static final Block MAGICAL_STAND = new BlockMagicalStand();
}
