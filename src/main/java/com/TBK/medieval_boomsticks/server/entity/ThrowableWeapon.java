package com.TBK.medieval_boomsticks.server.entity;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.common.items.JavelinItem;
import com.TBK.medieval_boomsticks.common.registers.MBEntityType;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class ThrowableWeapon extends AbstractArrow implements GeoEntity {
    private final AnimatableInstanceCache cache= GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(ThrowableWeapon.class, EntityDataSerializers.INT);
    protected ItemStack javelinItem = new ItemStack(MBItems.JAVELIN.get());
    protected boolean dealtDamage;
    private boolean fixedColor;

    public ThrowableWeapon(EntityType<? extends ThrowableWeapon> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_);
    }

    public ThrowableWeapon(EntityType<? extends ThrowableWeapon> pType,Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(pType, p_37570_, p_37569_);
        this.javelinItem = p_37571_.copy();
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_EFFECT_COLOR, -1);
    }

    public int getColor() {
        return this.entityData.get(ID_EFFECT_COLOR);
    }


    protected ItemStack getPickupItem() {
        return this.javelinItem.copy();
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
        return this.dealtDamage ? null : super.findHitEntity(p_37575_, p_37576_);
    }

    protected boolean tryPickup(Player p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoPhysics() && this.ownedBy(p_150196_) && p_150196_.getInventory().add(this.getPickupItem());
    }



    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.COPPER_HIT;
    }

    public boolean isRock(){
        return false;
    }

    public void playerTouch(Player p_37580_) {
        if (this.ownedBy(p_37580_) || this.getOwner() == null) {
            super.playerTouch(p_37580_);
        }

    }

    private void setFixedColor(int p_36883_) {
        this.fixedColor = true;
        this.entityData.set(ID_EFFECT_COLOR, p_36883_);
    }

    public void readAdditionalSaveData(CompoundTag p_37578_) {
        super.readAdditionalSaveData(p_37578_);
        if (p_37578_.contains("Trident", 10)) {
            this.javelinItem = ItemStack.of(p_37578_.getCompound("Trident"));
        }
        this.setFixedColor(p_37578_.getInt("Color"));

        this.dealtDamage = p_37578_.getBoolean("DealtDamage");
    }

    public void addAdditionalSaveData(CompoundTag p_37582_) {
        super.addAdditionalSaveData(p_37582_);
        p_37582_.put("Trident", this.javelinItem.save(new CompoundTag()));
        p_37582_.putBoolean("DealtDamage", this.dealtDamage);
        if (this.fixedColor) {
            p_37582_.putInt("Color", this.getColor());
        }
    }
    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object object) {
        return 0;
    }

}
