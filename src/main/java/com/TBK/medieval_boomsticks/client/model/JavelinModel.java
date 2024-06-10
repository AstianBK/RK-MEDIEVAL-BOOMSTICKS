package com.TBK.medieval_boomsticks.client.model;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.ArquebusItem;
import com.TBK.medieval_boomsticks.common.items.JavelinItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class JavelinModel<T extends GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"geo/javelin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/javelin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"animations/javelin.animations.json");
    }
}
