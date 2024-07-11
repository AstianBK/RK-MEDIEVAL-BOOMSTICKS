
package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.client.model.AxeModel;
import com.TBK.medieval_boomsticks.client.model.MorningStarModel;
import com.TBK.medieval_boomsticks.common.items.MorningStarItem;
import com.TBK.medieval_boomsticks.common.items.ThrowingAxeItem;
import com.TBK.medieval_boomsticks.common.items.ThrowingItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MorningStarRenderer<T extends MorningStarItem> extends GeoItemRenderer<T> {
    public MorningStarRenderer() {
        super(new MorningStarModel<>());
    }
}
