package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.AxeModel;
import com.TBK.medieval_boomsticks.client.model.KnifeModel;
import com.TBK.medieval_boomsticks.common.items.ThrowingItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AxeRenderer<T extends ThrowingItem> extends GeoItemRenderer<T> {
    public AxeRenderer() {
        super(new AxeModel<>());
    }
}
