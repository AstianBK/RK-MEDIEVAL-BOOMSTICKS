package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.RechargeItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class MBItemProperties {
    public static void register() {
        ItemProperties.register(MBItems.HANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "charged"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isCharged(p_239425_0_) ?  1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.HANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "recharge"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isReCharge(p_239425_0_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.ARQUEBUS.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "charged"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isCharged(p_239425_0_) ?  1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.ARQUEBUS.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "recharge"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isReCharge(p_239425_0_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.JAVELIN.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "aim"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && p_239425_2_.getUseItem()==p_239425_0_ ? 1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.JAVELIN.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "epic_fight"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && ModList.get().isLoaded("epicfight") ? 1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.ARQUEBUS.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "epic_fight"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && ModList.get().isLoaded("epicfight")?  1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.ARQUEBUS.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "fire"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isFire(p_239425_0_) ?  1.0F : 0.0F;
        });
    }
}
