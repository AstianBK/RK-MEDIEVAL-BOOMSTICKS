package com.TBK.medieval_boomsticks.client.model;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class EveningStarModel<T extends GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"geo/eveningstar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        if(animatable.equals(MBItems.EVENINGSTAR_METAL.get())){
            return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/eveningstar_metal.png");
        }
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/eveningstar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"animations/eveningstar.animations.json");
    }
}
