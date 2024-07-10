package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.RockModel;
import com.TBK.medieval_boomsticks.common.items.ThrowingItem;
import com.mojang.blaze3d.vertex.PoseStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LargeRockRenderer<T extends ThrowingItem> extends GeoItemRenderer<T> {
    public LargeRockRenderer() {
        super(new RockModel<>());
    }
}
