package com.TBK.medieval_boomsticks.client.layers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.client.renderer.ThrownJavelinRenderer;
import com.TBK.medieval_boomsticks.server.entity.ThrownJavelin;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class ThrownJavelinClothLayers<T extends ThrownJavelin> extends GeoRenderLayer<T> {
    public ThrownJavelinClothLayers(GeoRenderer entityRendererIn) {
        super(entityRendererIn);
    }
    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType renderType1=RenderType.entityCutoutNoCull(getTexture());
        int i =animatable.getColor();
        BakedGeoModel model=getGeoModel().getBakedModel(new ResourceLocation(RKMedievalBoomStick.MODID,"geo/javelin.geo.json"));
        float red = 1.0F;
        float green = 1.0F;
        float blue = 1.0F;
        if(i !=-1){
            red = (float)(i >> 16 & 255)/255;
            green = (float)(i >> 8 & 255)/255;
            blue = (float)(i & 255)/255;
        }
        getRenderer().reRender(model,poseStack,bufferSource,animatable,renderType1,bufferSource.getBuffer(renderType1),partialTick,packedLight
                , OverlayTexture.NO_OVERLAY,red,green,blue,1.0F);

    }

    public ResourceLocation getTexture(){
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/javelin_cloth.png");
    }
}
