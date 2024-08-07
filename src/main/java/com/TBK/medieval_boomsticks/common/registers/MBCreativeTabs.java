package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MBCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RKMedievalBoomStick.MODID);

    public static final RegistryObject<CreativeModeTab> MB_MOBS_TAB = TABS.register(RKMedievalBoomStick.MODID,()-> CreativeModeTab.builder()
            .icon(()->new ItemStack(MBItems.ARQUEBUS.get()))
            .title(Component.translatable("itemGroup.medieval_boomstick"))
            .displayItems((s,a)-> {
                a.accept(MBItems.SMALL_THROWING_ROCK.get());
                a.accept(MBItems.LARGE_THROWING_ROCK.get());
                a.accept(MBItems.MORNINGSTAR.get());
                a.accept(MBItems.EVENINGSTAR.get());
                a.accept(MBItems.GOTHEVENINGSTAR.get());
                a.accept(MBItems.THROWING_WARDART.get());
                a.accept(MBItems.ARQUEBUS.get());
                a.accept(MBItems.HANDGONNE.get());
                a.accept(MBItems.ARBALEST.get());
                a.accept(MBItems.SPIKEHANDGONNE.get());
                a.accept(MBItems.RECURVE_BOW.get());
                a.accept(MBItems.IRON_THROWING_KNIFE.get());
                a.accept(MBItems.IRON_THROWING_AXE.get());
                a.accept(MBItems.JAVELIN.get());
                a.accept(MBItems.HEAVY_BOLT.get());
                a.accept(MBItems.ROUND_BALL.get());
            })
            .build());
}
