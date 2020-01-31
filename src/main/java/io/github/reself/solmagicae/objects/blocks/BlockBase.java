package io.github.reself.solmagicae.objects.blocks;

import io.github.reself.solmagicae.Main;
import io.github.reself.solmagicae.init.BlockInit;
import io.github.reself.solmagicae.init.ItemInit;
import io.github.reself.solmagicae.util.IHasModel;
import io.github.reself.solmagicae.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{
	
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(Reference.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(Main.SOLMAGICAETAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
