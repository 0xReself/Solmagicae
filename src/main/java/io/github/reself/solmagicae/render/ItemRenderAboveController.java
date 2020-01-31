package io.github.reself.solmagicae.render;

import org.lwjgl.opengl.GL11;

import io.github.reself.solmagicae.entity.TileEntitySolarArray;
import io.github.reself.solmagicae.entity.TileEntitySolarController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemRenderAboveController extends TileEntitySpecialRenderer<TileEntitySolarArray> {
	ItemStack stack = new ItemStack(Items.DIAMOND, 1, 0);
	EntityItem entItem = new EntityItem(Minecraft.getMinecraft().world, 0D, 0D, 0D, stack);
	
	@Override
	public void render(TileEntitySolarArray te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {	
		GlStateManager.pushAttrib();
	    GlStateManager.pushMatrix();

	        // Translate to the location of our tile entity
	    GlStateManager.translate(x, y, z);
	    GlStateManager.disableRescaleNormal();

	        // Render the rotating handles

	        // Render our item
	    renderItem(te); 
	    GlStateManager.popMatrix();
	    GlStateManager.popAttrib();
	}

   
    private void renderItem(TileEntitySolarArray te) {
        ItemStack stack = new ItemStack(Items.DIAMOND, 1, 0);
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