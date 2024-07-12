
package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.GotheveningStarModel;
import com.TBK.medieval_boomsticks.common.items.GotheveningStarItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GotheveningStarRenderer<T extends GotheveningStarItem> extends GeoItemRenderer<T> {
    public GotheveningStarRenderer() {
        super(new GotheveningStarModel<>());
    }
}
