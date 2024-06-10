package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.JavelinModel;
import com.TBK.medieval_boomsticks.server.ThrownJavelin;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class ThrownJavelinRenderer<T extends ThrownJavelin> extends GeoEntityRenderer<T> {
    public ThrownJavelinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,new JavelinModel<>());
    }

    @Override
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick,animatable.yRotO,animatable.getYRot())+180.0F));
        poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTick,animatable.xRotO,animatable.getXRot())));
    }

    @Override
    protected void applyRotations(T animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {

    }
}
