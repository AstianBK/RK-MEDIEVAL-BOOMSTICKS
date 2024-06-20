package com.TBK.medieval_boomsticks.server;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Events {
    @SubscribeEvent
    public static void onHurtLivingEntity(LivingHurtEvent event) {
        System.out.print("\n"+(event.getSource().toString())+":"+ event.getAmount() +"\n");
    }
}