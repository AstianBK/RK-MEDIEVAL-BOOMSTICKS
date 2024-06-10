package com.TBK.medieval_boomsticks.client.layers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.JavelinItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class JavelinClothLayers<T extends JavelinItem> extends ItemGeoRenderLayer<T> {
    public JavelinClothLayers(GeoRenderer entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(ItemStack stack, PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType renderType1=RenderType.itemEntityTranslucentCull(getTexture());
        float red = 1.0F;
        float green = 1.0F;
        float blue = 1.0F;
        if(stack.getItem() instanceof DyeableLeatherItem dyeableLeatherItem && dyeableLeatherItem.hasCustomColor(stack)){
            if(dyeableLeatherItem.getColor(stack)!=0){
                int i = dyeableLeatherItem.getColor(stack);
                red = (float)(i >> 16 & 255)/255;
                green = (float)(i >> 8 & 255)/255;
                blue = (float)(i & 255)/255;
            }
        }
        getRenderer().reRender(bakedModel,poseStack,bufferSource,animatable,renderType1,bufferSource.getBuffer(renderType1),partialTick,packedLight
                , OverlayTexture.NO_OVERLAY,red,green,blue,1.0F);
    }

    

    public ResourceLocation getTexture(){
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/javelin_cloth.png");
    }
}
