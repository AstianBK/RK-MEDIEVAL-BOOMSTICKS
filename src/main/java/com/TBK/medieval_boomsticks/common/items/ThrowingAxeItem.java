package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.client.renderer.ArbalestRenderer;
import com.TBK.medieval_boomsticks.client.renderer.AxeRenderer;
import com.TBK.medieval_boomsticks.client.renderer.ThrownAxeRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Consumer;

public class ThrowingAxeItem extends ThrowingItem {
    public ThrowingAxeItem(Properties p_41383_) {
        super(p_41383_,ThrowableItems.AXE);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new AxeRenderer<>();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }
}
