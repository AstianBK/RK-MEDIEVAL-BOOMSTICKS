package com.TBK.medieval_boomsticks.client.model;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.ArquebusItem;
import com.TBK.medieval_boomsticks.common.items.HandGonneItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArquebusModel<T extends ArquebusItem> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"geo/arquebus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/arquebus.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"animations/arquebus.animation.json");
    }
}
