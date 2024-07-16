package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.client.renderer.AxeRenderer;
import com.TBK.medieval_boomsticks.common.registers.MBSounds;
import com.TBK.medieval_boomsticks.server.entity.ThrowableAxe;
import com.TBK.medieval_boomsticks.server.entity.ThrowableWeapon;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ThrowingAxeItem extends ThrowingItem {
    public boolean isCursed = false;
    public ThrowingAxeItem(Properties p_41383_) {
        super(p_41383_,ThrowableItems.AXE, Config.axeDamage,-3.0D);
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

    @Override
    public double getDamage() {
        return Config.axeDamage;
    }
    public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
        ItemStack itemstack = p_43143_.getItemInHand(p_43144_);
        p_43142_.playSound((Player)null, p_43143_, MBSounds.THROW_WEAPON.get(), SoundSource.PLAYERS, 1.0F,1.0F);
        if (!p_43142_.isClientSide) {
            ItemStack stack=itemstack.copy();
            stack.setCount(1);
            ThrowableAxe throwableWeapon = new ThrowableAxe(p_43142_, p_43143_,stack);
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
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        if(p_41406_ instanceof Player){
            if(p_41404_.getItem()   instanceof ThrowingAxeItem axeItem){
                this.setCursed(p_41404_.getOrCreateTag(),p_41404_.getHoverName().getString().equals("Cursed"));
            }
        }
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
    }

    public void setCursed(CompoundTag tag, boolean isCursed){
        this.isCursed=isCursed;
        tag.putBoolean("isCursed",isCursed);
    }

    public void setCursed(boolean isCursed){
        this.isCursed= isCursed;
    }

    public boolean isCursed(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTag();
        if(tag.contains("isCursed")){
            return tag.getBoolean("isCursed");
        }
        return false;
    }
    public boolean isCursed(){
        return this.isCursed;
    }
}
