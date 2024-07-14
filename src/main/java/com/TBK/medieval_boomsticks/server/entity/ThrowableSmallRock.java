package com.TBK.medieval_boomsticks.server.entity;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.common.registers.MBEntityType;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ThrowableSmallRock extends ThrowableWeapon {
    private static final EntityDataAccessor<Boolean> IMPACT = SynchedEntityData.defineId(ThrowableSmallRock.class, EntityDataSerializers.BOOLEAN);

    public ThrowableSmallRock(EntityType<? extends ThrowableSmallRock> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_);
        this.setNoPhysics(true);
    }

    public ThrowableSmallRock(Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(MBEntityType.THROWN_SMALL_ROCK.get(),p_37569_,p_37570_,p_37571_);
    }

    public ItemStack getWeaponType(){
        return new ItemStack(MBItems.SMALL_THROWING_ROCK.get());
    }

    @Override
    public void tick() {
        super.tick();
        this.setNoPhysics(!this.isImpact());
    }

    protected void onHitEntity(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = (float) Config.smallRockDamage;

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
    protected void onHitBlock(BlockHitResult p_36755_) {
        SoundEvent soundevent = SoundEvents.TRIDENT_HIT;

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;

        this.playSound(soundevent, f1, 1.0F);
    }

    public boolean isImpact(){
        return this.entityData.get(IMPACT);
    }

    public void setImpact(boolean impact){
        this.entityData.set(IMPACT,impact);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag p_37582_) {
        super.addAdditionalSaveData(p_37582_);
        p_37582_.putBoolean("impact",this.isImpact());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_37578_) {
        super.readAdditionalSaveData(p_37578_);
        this.setImpact(p_37578_.getBoolean("impact"));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IMPACT,false);
    }

    protected boolean tryPickup(Player p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoPhysics() && this.ownedBy(p_150196_) && p_150196_.getInventory().add(this.getPickupItem());
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

}
