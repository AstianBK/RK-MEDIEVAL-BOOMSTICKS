package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.FireGunItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class MBItemProperties {
    public static void register() {
        ItemProperties.register(MBItems.HANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "charged"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && FireGunItem.isCharged(p_239425_0_) ?  1.0F : 0.0F;
        });
        ItemProperties.register(MBItems.HANDGONNE.get(), new ResourceLocation(RKMedievalBoomStick.MODID, "re-charge"), (p_239425_0_, p_239425_1_, p_239425_2_, intIn) -> {
            return p_239425_2_ != null && !FireGunItem.isCharged(p_239425_0_) ? 1.0F : 0.0F;
        });
    }
}
