package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.AnimationVanillaG;
import com.TBK.medieval_boomsticks.client.model.SpikeHandGonneModel;
import com.TBK.medieval_boomsticks.common.items.SpikedHandGonneItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.joml.Matrix4f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.state.BoneSnapshot;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SpikeHandGonneRenderer<T extends SpikedHandGonneItem> extends GeoItemRenderer<T> {
    public SpikeHandGonneRenderer() {
        super(new SpikeHandGonneModel<>());
    }

    @Override
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, RenderType renderType,
                               MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                               int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (!isReRender) {
            AnimationState<T> animationState = new AnimationState<>(animatable, 0, 0, partialTick, false);
            long instanceId = getInstanceId(animatable);

            animationState.setData(DataTickets.TICK, animatable.getTick(this.currentItemStack));
            animationState.setData(DataTickets.ITEM_RENDER_PERSPECTIVE, this.renderPerspective);
            animationState.setData(DataTickets.ITEMSTACK,this.currentItemStack);
            animatable.getAnimatableInstanceCache().getManagerForId(instanceId).setData(DataTickets.ITEM_RENDER_PERSPECTIVE, this.renderPerspective);
            if(this.renderPerspective.firstPerson()){
                this.model.addAdditionalStateData(animatable, instanceId, animationState::setData);
                this.model.handleAnimations(animatable, instanceId, animationState);
            }else {
                if (this.model.getBone("rod").isPresent() && this.model.getBone("ammo").isPresent() && this.model.getBone("main").isPresent()){
                    this.model.getBone("ammo").get().setScaleX(0.0F);
                    this.model.getBone("ammo").get().setScaleY(0.0F);
                    this.model.getBone("ammo").get().setScaleZ(0.0F);
                    this.model.getBone("rod").get().setScaleX(0.0F);
                    this.model.getBone("rod").get().setScaleY(0.0F);
                    this.model.getBone("rod").get().setScaleZ(0.0F);
                    GeoBone main=this.model.getBone("main").get();
                    BoneSnapshot initial=main.getInitialSnapshot();
                    AnimationVanillaG.setRotBone(main,initial.getRotX(), initial.getRotY(), initial.getRotZ());
                    AnimationVanillaG.setPositionBone(main, initial.getOffsetX(), initial.getOffsetY(), initial.getOffsetZ());
                    AnimationVanillaG.resetMain(main);
                }
            }
        }

        this.modelRenderTranslations = new Matrix4f(poseStack.last().pose());

        updateAnimatedTextureFrame(animatable);

        for (GeoBone group : model.topLevelBones()) {
            renderRecursively(poseStack, animatable, group, renderType, bufferSource, buffer, isReRender, partialTick, packedLight,
                    packedOverlay, red, green, blue, alpha);
        }
    }
}
