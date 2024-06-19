package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.HandGonneModel;
import com.TBK.medieval_boomsticks.common.items.HandGonneItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class HandGonneRenderer<T extends HandGonneItem> extends GeoItemRenderer<T> {
    public HandGonneRenderer() {
        super(new HandGonneModel<>());
    }
}
