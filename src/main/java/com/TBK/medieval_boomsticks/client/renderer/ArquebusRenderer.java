package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.ArquebusModel;
import com.TBK.medieval_boomsticks.common.items.ArquebusItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ArquebusRenderer<T extends ArquebusItem> extends GeoItemRenderer<T> {
    public ArquebusRenderer() {
        super(new ArquebusModel<>());
    }
}
