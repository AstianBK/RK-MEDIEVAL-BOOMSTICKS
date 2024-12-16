package com.TBK.medieval_boomsticks;

import com.TBK.medieval_boomsticks.common.blocks.RKFurnace;
import com.TBK.medieval_boomsticks.common.items.MazeItem;
import com.TBK.medieval_boomsticks.common.items.MorningStarItem;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import com.TBK.medieval_boomsticks.common.registers.MBSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RKMedievalBoomStick.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        LivingEntity target=event.getEntity();
        Entity source=event.getSource().getEntity();
        if(source instanceof LivingEntity living && living.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof MazeItem){
            float trueDamage=event.getAmount()*(((float)Config.mazeArmorPenetrationPercentage)*0.01F);
            float damage=event.getAmount()-trueDamage;
            event.setAmount(damage);
            target.invulnerableTime=0;
            target.hurt(living.damageSources().generic(),trueDamage);
            living.level().playSound(null,living,living.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof MorningStarItem ? MBSounds.MORNINGSTAR_HIT.get() : MBSounds.EVENINGSTAR_HIT.get(), SoundSource.PLAYERS,1.0F,1.0F);
        }
    }
    @SubscribeEvent
    public static void onPlaceBlock(BlockEvent.EntityPlaceEvent event){
        if(!event.getLevel().isClientSide()){

        }
    }

    @SubscribeEvent
    public static void onComputeFOV(ComputeFovModifierEvent event){
        ItemStack stack=event.getPlayer().getUseItem();
        float f=event.getFovModifier();
        if (event.getPlayer().isUsingItem()) {
            if (stack.is(MBItems.RECURVE_BOW.get())) {
                int i = event.getPlayer().getTicksUsingItem();
                float f1 = (float)i / 20.0F;
                if (f1 > 1.0F) {
                    f1 = 1.0F;
                } else {
                    f1 *= f1;
                }

                f *= 1.0F - f1 * 0.15F;
            } else if (Minecraft.getInstance().options.getCameraType().isFirstPerson() && event.getPlayer().isScoping()) {
                event.setNewFovModifier(0.1F);
            }
        }
        event.setNewFovModifier(f);
    }
}
