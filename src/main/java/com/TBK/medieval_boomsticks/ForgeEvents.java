package com.TBK.medieval_boomsticks;

import com.TBK.medieval_boomsticks.common.items.MorningStarItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RKMedievalBoomStick.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        LivingEntity target=event.getEntity();
        Entity source=event.getSource().getEntity();
        if(source instanceof LivingEntity living && living.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof MorningStarItem){
            float trueDamage=event.getAmount()*0.3F;
            float damage=event.getAmount()-trueDamage;
            event.setAmount(damage);
            target.invulnerableTime=0;
            target.hurt(living.damageSources().generic(),trueDamage);
        }
    }
}