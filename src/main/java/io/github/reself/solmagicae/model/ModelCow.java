package io.github.reself.solmagicae.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelCow extends ModelBase {
    public ModelRenderer leg4;
    public ModelRenderer shape10;

    public ModelCow() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape10 = new ModelRenderer(this, 0, 0);
        this.shape10.setRotationPoint(-8.0F, 0.5F, -8.0F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
        this.setRotateAngle(shape10, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape10.render(f5);
        this.leg4.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
