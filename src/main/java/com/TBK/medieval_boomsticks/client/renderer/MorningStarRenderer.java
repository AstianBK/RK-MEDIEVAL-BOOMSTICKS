
package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.MorningStarModel;
import com.TBK.medieval_boomsticks.common.items.MazeItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MorningStarRenderer<T extends MazeItem> extends GeoItemRenderer<T> {
    public MorningStarRenderer() {
        super(new MorningStarModel<>());
    }
}
