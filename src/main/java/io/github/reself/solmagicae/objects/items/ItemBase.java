package io.github.reself.solmagicae.objects.items;

import io.github.reself.solmagicae.Main;
import io.github.reself.solmagicae.init.ItemInit;
import io.github.reself.solmagicae.util.IHasModel;
import io.github.reself.solmagicae.util.Reference;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name)
	{
		setUnlocalizedName(Reference.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(Main.SOLMAGICAETAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}