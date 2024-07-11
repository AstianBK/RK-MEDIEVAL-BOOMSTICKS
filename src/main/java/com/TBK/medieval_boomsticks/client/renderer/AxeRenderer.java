package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.client.model.AxeModel;
import com.TBK.medieval_boomsticks.client.model.KnifeModel;
import com.TBK.medieval_boomsticks.common.items.ThrowingAxeItem;
import com.TBK.medieval_boomsticks.common.items.ThrowingItem;
import com.TBK.medieval_boomsticks.server.entity.ThrowableAxe;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AxeRenderer<T extends ThrowingItem> extends GeoItemRenderer<T> {
    public AxeRenderer() {
        super(new AxeModel<>());
    }

    @Override
    public ResourceLocation getTextureLocation(T animatable) {
        if((this.animatable instanceof ThrowingAxeItem axeItem && axeItem.isCursed(this.currentItemStack))){
            return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/axe_cursed.png");
        }
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/axe.png");

    }
}
