package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.RockModel;
import com.TBK.medieval_boomsticks.client.model.WarDartModel;
import com.TBK.medieval_boomsticks.server.entity.ThrowableSmallRock;
import com.TBK.medieval_boomsticks.server.entity.ThrowableWardart;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class ThrownSmallRockRenderer<T extends ThrowableSmallRock> extends GeoEntityRenderer<T> {
    public ThrownSmallRockRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,new RockModel<>());
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(0.3F,0.3F,0.3F);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void preRender(PoseStack poseStack, T animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if(!isReRender){
            poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick,animatable.yRotO,animatable.getYRot())+180.0F));
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTick,animatable.xRotO,animatable.getXRot())));
        }
    }

    @Override
    protected void applyRotations(T animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {

    }
}
