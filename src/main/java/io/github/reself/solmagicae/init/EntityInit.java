package io.github.reself.solmagicae.init;

import java.util.ArrayList;
import java.util.List;

import io.github.reself.solmagicae.Main;
import io.github.reself.solmagicae.entitys.EntityTest;
import io.github.reself.solmagicae.objects.blocks.MagicalCouldron;
import io.github.reself.solmagicae.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	public static void registerEntity( ) {
		registerEntity("test", EntityTest.class, 120, 50, 111111, 000000);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
}
