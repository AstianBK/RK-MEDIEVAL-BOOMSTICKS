package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.RechargeItem;
import com.TBK.medieval_boomsticks.common.items.ThrowingAxeItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;

public class MBItemProperties {
    public static void register() {
        ItemProperties.register(MBItems.HANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "charged"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isCharged(p_239425_0_) ?  1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.HANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "recharge"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isReCharge(p_239425_0_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.SPIKEHANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "charged"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isCharged(p_239425_0_) ?  1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.SPIKEHANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "recharge"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isReCharge(p_239425_0_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.ARBALEST.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "charged"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && RechargeItem.isCharged(p_239425_0_) ?  1.0F : 0.0F;
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

        ItemProperties.register(MBItems.RECURVE_BOW.get(), new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.RECURVE_BOW.get(), new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(MBItems.IRON_THROWING_AXE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "isCursed"), (p_239426_0_, p_239426_1_, p_239426_2_, intIn) -> {
            return p_239426_0_.getItem() instanceof ThrowingAxeItem axe && axe.isCursed(p_239426_0_) ? 1 : 0;
        });
    }
}
