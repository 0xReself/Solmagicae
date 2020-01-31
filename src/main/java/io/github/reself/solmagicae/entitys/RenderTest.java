package io.github.reself.solmagicae.entitys;

import io.github.reself.solmagicae.model.ModelCow;
import io.github.reself.solmagicae.util.Reference;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTest extends RenderLiving<EntityTest>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/test.png");
	
	public RenderTest(RenderManager manager) {
		super(manager, new ModelCow(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTest entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
}