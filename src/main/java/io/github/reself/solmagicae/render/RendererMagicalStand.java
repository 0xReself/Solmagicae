package io.github.reself.solmagicae.render;

import io.github.reself.solmagicae.entity.TileEntityMagicalStand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;

public class RendererMagicalStand extends TileEntitySpecialRenderer<TileEntityMagicalStand> {

	@Override
	public void render(TileEntityMagicalStand ms, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {	
		GlStateManager.pushAttrib();
	    GlStateManager.pushMatrix();

	        // Translate to the location of our tile entity
	    GlStateManager.translate(x, y, z);
	    GlStateManager.disableRescaleNormal();

	        // Render the rotating handles

	        // Render our item
	    renderItem(ms); 
	    GlStateManager.popMatrix();
	    GlStateManager.popAttrib();
	}
	
	private void renderItem(TileEntityMagicalStand ms) {
        ItemStack stack = ms.getStack();
        if (!stack.isEmpty()) {
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.pushMatrix();
            // Translate to the center of the block and .9 points higher
            GlStateManager.translate(.5, 2, .5);
            GlStateManager.scale(.4f, .4f, .4f);
            GlStateManager.rotate(9, 0, 1, 0);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
        }
    }
}
