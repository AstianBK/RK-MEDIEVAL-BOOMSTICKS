package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.*;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RKMedievalBoomStick.MODID);

    public static final RegistryObject<Item> HANDGONNE= ITEMS.register("handgonne",()->new HandGonneItem(new Item.Properties().stacksTo(1).durability(24)));

    public static final RegistryObject<Item> SPIKEHANDGONNE= ITEMS.register("spikedhandgonne",()->new SpikedHandGonneItem(new Item.Properties().stacksTo(1).durability(24)));

    public static final RegistryObject<Item> JAVELIN= ITEMS.register("javelin",()->new JavelinItem(new Item.Properties().stacksTo(1).durability(16)));
    public static final RegistryObject<Item> ARBALEST= ITEMS.register("arbalest",()->new ArbalestItem(new Item.Properties().stacksTo(1).durability(924)));
    public static final RegistryObject<Item> ARQUEBUS= ITEMS.register("arquebus",()->new ArquebusItem(new Item.Properties().stacksTo(1).durability(48)));

    public static final RegistryObject<Item> HEAVY_BOLT= ITEMS.register("heavy_bolt",()->new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> ROUND_BALL= ITEMS.register("round_ball",()->new ArrowItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> IRON_THROWING_KNIFE= ITEMS.register("iron_throwing_knife",()->new ThrowingItem(new Item.Properties(),ThrowableItems.KNIFE));
    public static final RegistryObject<Item> IRON_THROWING_AXE= ITEMS.register("iron_throwing_axe",()->new ThrowingAxeItem(new Item.Properties()));

    public static final RegistryObject<Item> SMALL_THROWING_ROCK= ITEMS.register("small_throwing_rock",()->new ThrowingItem(new Item.Properties(),ThrowableItems.SMALL_ROCK));
    public static final RegistryObject<Item> LARGE_THROWING_ROCK= ITEMS.register("large_throwing_rock",()->new ThrowingItem(new Item.Properties(),ThrowableItems.LARGE_ROCK));

    public static final RegistryObject<Item> THROWING_WARDART= ITEMS.register("war_dart",()->new WarDartItem(new Item.Properties().durability(16)));
    public static final RegistryObject<Item> RECURVE_BOW= ITEMS.register("recurve_bow",()->new BowItem(new Item.Properties()));

}
