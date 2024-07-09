package com.TBK.medieval_boomsticks.client.model;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.ThrowingAxeItem;
import com.TBK.medieval_boomsticks.server.entity.ThrowableAxe;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class AxeModel<T extends GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"geo/axe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        if((animatable instanceof ThrowingAxeItem axeItem && axeItem.isCursed) || (animatable instanceof ThrowableAxe axe && axe.isCursed())){
            return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/axe_cursed.png");
        }
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/axe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"animations/axe.animations.json");
    }
}
