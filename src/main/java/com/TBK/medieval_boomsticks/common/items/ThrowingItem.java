package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import com.TBK.medieval_boomsticks.client.renderer.ArquebusRenderer;
import com.TBK.medieval_boomsticks.client.renderer.KnifeRenderer;
import com.TBK.medieval_boomsticks.common.registers.MBEntityType;
import com.TBK.medieval_boomsticks.common.registers.MBSounds;
import com.TBK.medieval_boomsticks.server.entity.ThrowableAxe;
import com.TBK.medieval_boomsticks.server.entity.ThrowableWeapon;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class ThrowingItem extends Item implements GeoItem {
    private final AnimatableInstanceCache cache= GeckoLibUtil.createInstanceCache(this);
    private final double damage;
    private final double attackSpeed;
    public ThrowableItems type;
    public ThrowingItem(Properties p_40512_,ThrowableItems type,double damage,double attackSpeed) {
        super(p_40512_);
        this.damage=damage;
        this.attackSpeed=attackSpeed;
        this.type=type;
    }

    public InteractionResultHolder<ItemStack> use(Level p_43142_, Player p_43143_, InteractionHand p_43144_) {
        ItemStack itemstack = p_43143_.getItemInHand(p_43144_);
        p_43142_.playSound((Player)null, p_43143_, MBSounds.THROW_WEAPON.get(), SoundSource.PLAYERS, 1.0F,1.0F);
        if (!p_43142_.isClientSide) {
            ItemStack stack=itemstack.copy();
            stack.setCount(1);
            ThrowableWeapon throwableWeapon = new ThrowableWeapon(getEntityForType(this.type),p_43142_, p_43143_,stack);
            if(p_43143_.isCreative()){
                throwableWeapon.pickup= AbstractArrow.Pickup.CREATIVE_ONLY;
            }else {
                throwableWeapon.pickup= AbstractArrow.Pickup.ALLOWED;
            }
            if (itemstack.getItem() instanceof ThrowingAxeItem axeItem && axeItem.isCursed(itemstack)) {
                throwableWeapon= new ThrowableAxe(p_43142_,p_43143_,stack);
                ((ThrowableAxe)throwableWeapon).setIsCursed(true);
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
    public float getSpeedForType(ThrowableItems type){
        switch (type){
            case AXE -> {
                return 1.6F;
            }
            case KNIFE ->{
                return 2.0F;
            }
            case LARGE_ROCK -> {
                return (float) Config.largeRockSpeed;
            }
            case SMALL_ROCK -> {
                return (float) Config.smallRockSpeed;
            }
            default -> {
                return 1.5F;
            }
        }
    }

    public EntityType<? extends ThrowableWeapon> getEntityForType(ThrowableItems type){
        switch (type){
            case AXE -> {
                return MBEntityType.THROWN_AXE.get();
            }
            case LARGE_ROCK -> {
                return MBEntityType.THROWN_LARGE_ROCK.get();
            }
            case SMALL_ROCK -> {
                return MBEntityType.THROWN_SMALL_ROCK.get();
            }
            default -> {
                return MBEntityType.THROWN_KNIFE.get();
            }
        }

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
    public double getDamage(){
        return 1.0D;
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43383_) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", this.getDamage(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
        return p_43383_ == EquipmentSlot.MAINHAND ? builder.build() : super.getDefaultAttributeModifiers(p_43383_);
    }
}
