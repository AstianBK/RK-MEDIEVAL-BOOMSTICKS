package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.layers.ThrownJavelinClothLayers;
import com.TBK.medieval_boomsticks.client.model.JavelinModel;
import com.TBK.medieval_boomsticks.client.model.KnifeModel;
import com.TBK.medieval_boomsticks.server.entity.ThrowableKnife;
import com.TBK.medieval_boomsticks.server.entity.ThrownJavelin;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class ThrownKnifeRenderer<T extends ThrowableKnife> extends GeoEntityRenderer<T> {
    public ThrownKnifeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,new KnifeModel<>());
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
            if(!animatable.level().noCollision((new AABB(animatable.position(), animatable.position())).inflate(0.06D))){
                poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTick,animatable.xRotO,animatable.getXRot())));
            }else {
                poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTick,animatable.xRotO,animatable.getXRot())+(Mth.sin(30*animatable.tickCount)*360F)));
            }
        }
    }

    @Override
    protected void applyRotations(T animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {

    }
}
