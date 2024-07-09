package com.TBK.medieval_boomsticks.client.model;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.SpikedHandGonneItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpikeHandGonneModel<T extends SpikedHandGonneItem> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"geo/spikedhandgonne.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/spiked_handgonne.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"animations/spikedhandgonne.animation.json");
    }


}
