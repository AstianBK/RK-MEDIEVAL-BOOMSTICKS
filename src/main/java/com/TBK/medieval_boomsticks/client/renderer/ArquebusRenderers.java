package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.ArquebusModel;
import com.TBK.medieval_boomsticks.client.model.HandGonneModel;
import com.TBK.medieval_boomsticks.common.items.ArquebusItem;
import com.TBK.medieval_boomsticks.common.items.HandGonneItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ArquebusRenderers<T extends ArquebusItem> extends GeoItemRenderer<T> {
    public ArquebusRenderers() {
        super(new ArquebusModel<>());
    }
}
