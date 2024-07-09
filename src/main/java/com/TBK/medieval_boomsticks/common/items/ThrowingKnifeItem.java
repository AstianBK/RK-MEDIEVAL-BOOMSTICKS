package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.client.renderer.AxeRenderer;
import com.TBK.medieval_boomsticks.client.renderer.KnifeRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ThrowingKnifeItem extends ThrowingItem {
    public boolean isCursed = false;
    public ThrowingKnifeItem(Properties p_41383_) {
        super(p_41383_,ThrowableItems.KNIFE);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new KnifeRenderer<>();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        this.isCursed=this.isCursed(stack);
        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
    }

    public boolean isCursed(ItemStack stack){
        return stack.getHoverName().getString().equals("Cursed");
    }
}
