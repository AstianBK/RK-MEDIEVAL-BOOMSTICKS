package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.client.renderer.HandGonneRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.EasingType;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Consumer;

public class HandGonneItem extends RechargeItem {

    public HandGonneItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new HandGonneRenderer<>();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this,"controller",0,e->{
            ItemStack stack= (ItemStack) e.getData(DataTickets.ITEMSTACK);
            e.getController().setAnimationSpeed(1.0D);
            if(stack==null){
                e.getController().setAnimation(RawAnimation.begin().thenLoop("handgonne.idle"));
                return PlayState.CONTINUE;
            }
            if (isReCharge(stack)) {
                e.getController().setAnimationSpeed(2.0D*Config.rechargeSpeedHandgonne);
                e.getController().setAnimation(RawAnimation.begin().thenPlayAndHold("handgonne.reload"));
            }else{
                e.getController().setAnimation(RawAnimation.begin().thenLoop("handgonne.idle"));
            }

            return PlayState.CONTINUE;
        }));
    }
}
