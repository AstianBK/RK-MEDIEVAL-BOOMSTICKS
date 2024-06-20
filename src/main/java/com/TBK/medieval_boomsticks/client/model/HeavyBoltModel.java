package com.TBK.medieval_boomsticks.client.model;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class HeavyBoltModel<T extends GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"geo/heavy_bolt_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/arbalest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"animations/heavy_bolt_projectile.animations.json");
    }
}
