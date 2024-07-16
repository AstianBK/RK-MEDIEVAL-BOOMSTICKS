package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.client.renderer.KnifeRenderer;
import com.TBK.medieval_boomsticks.client.renderer.SmallRockRenderer;
import com.TBK.medieval_boomsticks.common.registers.MBSounds;
import com.TBK.medieval_boomsticks.server.entity.ThrowableSmallRock;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
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
    public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
        ItemStack itemstack = p_43143_.getItemInHand(p_43144_);
        p_43142_.playSound((Player)null, p_43143_, MBSounds.THROW_WEAPON.get(), SoundSource.PLAYERS, 1.0F,1.0F);
        if (!p_43142_.isClientSide) {
            ItemStack stack=itemstack.copy();
            stack.setCount(1);
            ThrowableSmallRock throwableWeapon = new ThrowableSmallRock(p_43142_, p_43143_,stack);
            if(p_43143_.isCreative()){
                throwableWeapon.pickup= AbstractArrow.Pickup.CREATIVE_ONLY;
            }else {
                throwableWeapon.pickup= AbstractArrow.Pickup.DISALLOWED;
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
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43383_) {
        return ImmutableMultimap.of();
    }
}
