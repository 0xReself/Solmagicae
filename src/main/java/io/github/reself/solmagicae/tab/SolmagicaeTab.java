package io.github.reself.solmagicae.tab;

import io.github.reself.solmagicae.init.ItemInit;
import io.github.reself.solmagicae.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SolmagicaeTab extends CreativeTabs{
	
	public SolmagicaeTab() {
		super(Reference.MODID);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.MAGICAL_STICK);
	}
}
