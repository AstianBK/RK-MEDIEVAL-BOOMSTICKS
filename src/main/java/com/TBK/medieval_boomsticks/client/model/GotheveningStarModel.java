package com.TBK.medieval_boomsticks.client.model;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.GotheveningStarItem;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class GotheveningStarModel<T extends GotheveningStarItem> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"geo/gotheveningstar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        if(animatable.equals(MBItems.GOTHEVENINGSTAR_METAL.get())){
            return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/gotheveningstar_metal.png");
        }
        return new ResourceLocation(RKMedievalBoomStick.MODID,"textures/item/gotheveningstar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"animations/gotheveningstar.animations.json");
    }
}
