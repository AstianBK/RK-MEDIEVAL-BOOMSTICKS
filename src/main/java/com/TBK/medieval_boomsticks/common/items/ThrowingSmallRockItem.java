package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.client.renderer.KnifeRenderer;
import com.TBK.medieval_boomsticks.client.renderer.SmallRockRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ThrowingSmallRockItem extends ThrowingItem {
    public ThrowingSmallRockItem(Properties p_41383_) {
        super(p_41383_,ThrowableItems.SMALL_ROCK,1,0.0D);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new SmallRockRenderer<>();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }
}
