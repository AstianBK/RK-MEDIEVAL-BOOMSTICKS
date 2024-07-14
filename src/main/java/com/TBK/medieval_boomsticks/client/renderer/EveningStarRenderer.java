
package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.EveningStarModel;
import com.TBK.medieval_boomsticks.client.model.GotheveningStarModel;
import com.TBK.medieval_boomsticks.common.items.EveningStarItem;
import com.TBK.medieval_boomsticks.common.items.GotheveningStarItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class EveningStarRenderer<T extends EveningStarItem> extends GeoItemRenderer<T> {
    public EveningStarRenderer() {
        super(new EveningStarModel<>());
    }
}
