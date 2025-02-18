package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MBTags {
    public static final TagKey<Item> IS_TOOL_FOR_FURNACE = tag("is_tool_for_furnace");
    public static final TagKey<Item> IS_FUEL_FOR_SMITHING_FURNACE = tag("is_fuel_for_smithing_furnace");
    public static final TagKey<Item> IS_TONG = tag("blacksmith_tong");
    public static final TagKey<Item> IS_BELLOW = tag("blacksmith_bellow");
    public static final TagKey<Item> IS_HAMMER = tag("blacksmith_hammer");


    private static TagKey<Item> tag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(RKMedievalBoomStick.MODID, name));
    }
}
