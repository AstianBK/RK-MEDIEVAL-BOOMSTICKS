package com.TBK.medieval_boomsticks.server.entity;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.common.registers.MBEntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrowableLargeRock extends ThrowableWeapon {

    public ThrowableLargeRock(EntityType<? extends ThrowableLargeRock> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_);
    }
    public ThrowableLargeRock(Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(MBEntityType.THROWN_LARGE_ROCK.get(),p_37569_,p_37570_,p_37571_);
    }

    protected void onHitEntity(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = (float) Config.largeRockDamage;

        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().trident(this, (Entity)(entity1 == null ? this : entity1));
        this.dealtDamage = true;
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

        this.discard();

    }

    @Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        super.onHitBlock(p_36755_);
        this.javelinItem=null;
        this.dealtDamage=true;
        this.pickup=Pickup.DISALLOWED;
        this.discard();
    }

    @Override
    public boolean isRock() {
        return true;
    }

    @Override
    protected void onHit(HitResult p_37260_) {
        super.onHit(p_37260_);

    }

    protected boolean tryPickup(Player p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoPhysics() && this.ownedBy(p_150196_) && p_150196_.getInventory().add(this.getPickupItem());
    }

}
