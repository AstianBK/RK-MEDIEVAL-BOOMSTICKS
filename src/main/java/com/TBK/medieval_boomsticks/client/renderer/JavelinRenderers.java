package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.ArquebusModel;
import com.TBK.medieval_boomsticks.client.model.JavelinModel;
import com.TBK.medieval_boomsticks.common.items.ArquebusItem;
import com.TBK.medieval_boomsticks.common.items.JavelinItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class JavelinRenderers<T extends JavelinItem> extends GeoItemRenderer<T> {
    public JavelinRenderers() {
        super(new JavelinModel<>());
    }

    @Override
    public void defaultRender(PoseStack poseStack, T animatable, MultiBufferSource bufferSource, @Nullable RenderType renderType, @Nullable VertexConsumer buffer, float yaw, float partialTick, int packedLight) {
        super.defaultRender(poseStack, animatable, bufferSource, renderType, buffer, yaw, partialTick, packedLight);
    }
}
