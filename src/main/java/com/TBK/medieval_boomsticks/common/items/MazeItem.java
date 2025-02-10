package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.client.renderer.MorningStarRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Consumer;

public class MazeItem extends AxeItem implements GeoItem {
    private final AnimatableInstanceCache cache= GeckoLibUtil.createInstanceCache(this);

    public MazeItem(Properties p_43381_,float damage,float attackSpeed) {
        super(Tiers.WOOD,damage,attackSpeed,p_43381_);
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new MorningStarRenderer<>();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(Component.literal("+"+Config.mazeArmorPenetrationPercentage+"% ").append(Component.translatable("item.medieval_boomsticks.maze.passive")).withStyle(ChatFormatting.GREEN));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }


}
