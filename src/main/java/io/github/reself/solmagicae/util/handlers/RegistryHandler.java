package io.github.reself.solmagicae.util.handlers;

import io.github.reself.solmagicae.init.BlockInit;
import io.github.reself.solmagicae.init.EntityInit;
import io.github.reself.solmagicae.init.ItemInit;
import io.github.reself.solmagicae.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void OnItemRegister(Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void OnBlockRegister(Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	
	// Checks for Resource to load
	@SubscribeEvent
	public static void OnModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ItemInit.ITEMS) {
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS) { 
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
}
