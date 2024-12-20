package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.client.renderer.KnifeRenderer;
import com.TBK.medieval_boomsticks.common.registers.MBSounds;
import com.TBK.medieval_boomsticks.server.entity.ThrowableAxe;
import com.TBK.medieval_boomsticks.server.entity.ThrowableKnife;
import com.TBK.medieval_boomsticks.server.entity.ThrowableWeapon;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ThrowingKnifeItem extends ThrowingItem {
    public ThrowingKnifeItem(Properties p_41383_) {
        super(p_41383_,ThrowableItems.KNIFE,Config.knifeDamage,-2.5D);

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
    public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
        ItemStack itemstack = p_43143_.getItemInHand(p_43144_);
        p_43142_.playSound((Player)null, p_43143_, MBSounds.THROW_WEAPON.get(), SoundSource.PLAYERS, 1.0F,1.0F);
        if (!p_43142_.isClientSide) {
            itemstack.hurtAndBreak(1, p_43143_, (p_43388_) -> {
                p_43388_.broadcastBreakEvent(p_43143_.getUsedItemHand());
            });
            ItemStack stack=itemstack.copy();
            stack.setCount(1);
            ThrowableKnife throwableWeapon = new ThrowableKnife(p_43142_, p_43143_,stack);
            if(p_43143_.isCreative()){
                throwableWeapon.pickup= AbstractArrow.Pickup.CREATIVE_ONLY;
            }else {
                throwableWeapon.pickup= AbstractArrow.Pickup.ALLOWED;
            }
            throwableWeapon.shootFromRotation(p_43143_, p_43143_.getXRot(), p_43143_.getYRot(), 0.0F, this.getSpeedForType(this.type), 1.0F);
            p_43142_.addFreshEntity(throwableWeapon);
        }

        p_43143_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_43143_.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, p_43142_.isClientSide());
    }

    @Override
    public double getDamage() {
        return Config.knifeDamage;
    }
}
