package com.TBK.medieval_boomsticks.client;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.ThrowingAxeItem;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = RKMedievalBoomStick.MODID, bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(RegisterColorHandlersEvent.Item event) {
        event.register((p_92708_, p_92709_) -> {
            return p_92709_ > 0 ? -1 : ((DyeableLeatherItem)p_92708_.getItem()).getColor(p_92708_);
        }, MBItems.JAVELIN.get());
    }

}
