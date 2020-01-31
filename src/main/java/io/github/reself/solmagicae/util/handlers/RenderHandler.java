package io.github.reself.solmagicae.util.handlers;

import io.github.reself.solmagicae.entitys.EntityTest;
import io.github.reself.solmagicae.entitys.RenderTest;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new IRenderFactory<EntityTest>() {

			@Override
			public Render<? super EntityTest> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderTest(manager);
			}
		
		});
	}
}
