package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.HandGonneItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RKMedievalBoomStick.MODID);

    public static final RegistryObject<Item> HANDGONNE= ITEMS.register("handgonne",()->new HandGonneItem(new Item.Properties()));
    public static final RegistryObject<Item> JAVELIN= ITEMS.register("javelin",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARBALEST= ITEMS.register("arbalest",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARQUEBUS= ITEMS.register("arquebus",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_BOLT= ITEMS.register("heavy_bolt",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROUND_BALL= ITEMS.register("round_ball",()->new Item(new Item.Properties()));

}
