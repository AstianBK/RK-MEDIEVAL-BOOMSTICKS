package com.TBK.medieval_boomsticks.server.entity;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.common.registers.MBEntityType;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class ThrowableAxe extends ThrowableWeapon {
    private static final EntityDataAccessor<Boolean> IS_CURSED = SynchedEntityData.defineId(ThrowableAxe.class, EntityDataSerializers.BOOLEAN);

    public ThrowableAxe(EntityType<? extends ThrowableAxe> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_);
    }

    public ThrowableAxe(Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(MBEntityType.THROWN_AXE.get(),p_37569_,p_37570_,p_37571_);
    }

    public ItemStack getWeaponType(){
        return new ItemStack(MBItems.IRON_THROWING_AXE.get());
    }

    protected void onHitEntity(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = (float) Config.javelinDamage;
        if (entity instanceof LivingEntity livingentity) {
            f += EnchantmentHelper.getDamageBonus(this.javelinItem, livingentity.getMobType());
        }

        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().trident(this, (Entity)(entity1 == null ? this : entity1));
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.TRIDENT_HIT;
        if (entity.hurt(damagesource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingentity1 = (LivingEntity)entity;
                if (entity1 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity1, entity1);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)entity1, livingentity1);
                }

                this.doPostHurtEffects(livingentity1);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;

        this.playSound(soundevent, f1, 1.0F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_CURSED,false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_37582_) {
        p_37582_.putBoolean("isCursed",this.isCursed());
        super.addAdditionalSaveData(p_37582_);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_37578_) {
        this.setIsCursed(p_37578_.getBoolean("isCursed"));
        super.readAdditionalSaveData(p_37578_);
    }

    public boolean isCursed() {
        return this.entityData.get(IS_CURSED);
    }

    public void setIsCursed(boolean isCursed){
        this.entityData.set(IS_CURSED,isCursed);
    }

    protected boolean tryPickup(Player p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoPhysics() && this.ownedBy(p_150196_) && p_150196_.getInventory().add(this.getPickupItem());
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

}
