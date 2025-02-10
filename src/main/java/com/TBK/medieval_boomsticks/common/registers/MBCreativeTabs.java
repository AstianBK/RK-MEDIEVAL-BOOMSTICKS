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

                a.accept(MBItems.MORNINGSTAR_METAL.get());
                a.accept(MBItems.EVENINGSTAR_METAL.get());
                a.accept(MBItems.GOTHEVENINGSTAR_METAL.get());

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
                a.accept(MBItems.AQUA_FORTIS.get());
                a.accept(MBItems.FINISHED_LEATHER.get());
                a.accept(MBItems.FINISHED_OIL.get());
                a.accept(MBItems.FINISHED_OIL_BUCKET.get());
                a.accept(MBItems.FINISHED_SHAFT.get());
                a.accept(MBItems.BULAT_BAR.get());
                a.accept(MBItems.DZIWER_BAR.get());
                a.accept(MBItems.CANVAS.get());
                a.accept(MBItems.PADDED_CANVAS.get());
                a.accept(MBItems.QUILTED_CANVAS.get());
                a.accept(MBItems.UPGRADE_KIT.get());
                a.accept(MBItems.YARROW.get());
                a.accept(MBItems.SAGE.get());
                a.accept(MBItems.YELLOW_WOOD_SORREL.get());
                a.accept(MBItems.LEMON_BALM.get());
                a.accept(MBItems.ARNICA.get());
                a.accept(MBItems.COMFREY.get());
                a.accept(MBItems.RAW_LIMONITE.get());
                a.accept(MBItems.RAW_PYRITE.get());
                a.accept(MBItems.RAW_MAGNETITE.get());
                a.accept(MBItems.SULFUR.get());
                a.accept(MBItems.NITRE.get());
                a.accept(MBItems.SMITHING_HAMMER.get());
                a.accept(MBItems.SMITHING_BELLOWS.get());
                a.accept(MBItems.SMITHING_TONGS.get());

                a.accept(MBItems.SMALL_GUNMETAL_BARREL.get());
                a.accept(MBItems.SMALL_IRON_BARREL.get());

                a.accept(MBItems.GUNMETAL_BARREL.get());
                a.accept(MBItems.IRON_BARREL.get());

                a.accept(MBItems.LARGE_GUNMETAL_BARREL.get());
                a.accept(MBItems.LARGE_IRON_BARREL.get());

                a.accept(MBItems.GUN_TRIGGER.get());
                a.accept(MBBlocks.SMITHING_FURNACE.get());

                a.accept(MBBlocks.MAGNETITE_ORE.get());
                a.accept(MBBlocks.MAGNETITE_ORE_DEEPSLATE.get());

                a.accept(MBBlocks.LIMONITE_ORE.get());
                a.accept(MBBlocks.LIMONITE_ORE_DEEPSLATE.get());

                a.accept(MBBlocks.SULFUR_ORE_BLOCK.get());
                a.accept(MBBlocks.SULFUR_ORE.get());
                a.accept(MBBlocks.SULFUR_ORE_DEEPSLATE.get());

                a.accept(MBBlocks.PYRITE_ORE.get());
                a.accept(MBBlocks.PYRITE_ORE_DEEPSLATE.get());
            })
            .build());
}
