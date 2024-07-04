package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.layers.ItemGeoRenderLayer;
import com.TBK.medieval_boomsticks.client.layers.JavelinClothLayers;
import com.TBK.medieval_boomsticks.client.model.JavelinModel;
import com.TBK.medieval_boomsticks.client.model.WarDartModel;
import com.TBK.medieval_boomsticks.common.items.JavelinItem;
import com.TBK.medieval_boomsticks.common.items.WarDartItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class WarDartRenderer<T extends WarDartItem> extends GeoItemRenderer<T> {
    public WarDartRenderer() {
        super(new WarDartModel<>());
    }
}
