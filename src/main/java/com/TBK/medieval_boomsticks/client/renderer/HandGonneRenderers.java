package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.HandGonneModel;
import com.TBK.medieval_boomsticks.common.items.HandGonneItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class HandGonneRenderers<T extends HandGonneItem> extends GeoItemRenderer<T> {
    public HandGonneRenderers() {
        super(new HandGonneModel<>());
    }
}
