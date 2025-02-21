package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.SmithingHammerModel;
import com.TBK.medieval_boomsticks.common.items.HammerItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SmithingHammerRenderer<T extends HammerItem> extends GeoItemRenderer<T> {
    public SmithingHammerRenderer() {
        super(new SmithingHammerModel<>());
    }
}
