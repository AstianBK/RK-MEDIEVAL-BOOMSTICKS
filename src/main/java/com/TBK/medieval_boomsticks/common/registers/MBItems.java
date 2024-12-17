package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.items.*;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RKMedievalBoomStick.MODID);


    public static final RegistryObject<Item> BULAT_BAR= ITEMS.register("bulat_bar",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CANVAS= ITEMS.register("canvas",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> DZIWER_BAR= ITEMS.register("dziwer_bar",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FINISHED_LEATHER= ITEMS.register("finished_leather",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FINISHED_OIL= ITEMS.register("finished_oil",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FINISHED_OIL_BUCKET= ITEMS.register("finished_oil_bucket",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FINISHED_SHAFT= ITEMS.register("finished_shaft",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> PADDED_CANVAS= ITEMS.register("padded_canvas",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> QUILTED_CANVAS= ITEMS.register("quilted_canvas",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> NITRE= ITEMS.register("nitre",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SULFUR= ITEMS.register("sulfur",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> AQUA_FORTIS= ITEMS.register("aqua_fortis",()->new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> UPGRADE_KIT= ITEMS.register("upgrade_kit",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RAW_LIMONITE= ITEMS.register("raw_limonite",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RAW_PYRITE= ITEMS.register("raw_pyrite",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RAW_MAGNETITE = ITEMS.register("raw_magnetite",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SMITHING_BELLOWS= ITEMS.register("smithing_bellows",()->new Item(new Item.Properties().stacksTo(1).durability(128)));

    public static final RegistryObject<Item> SMITHING_HAMMER= ITEMS.register("smithing_hammer",()->new Item(new Item.Properties().stacksTo(1).durability(64)));

    public static final RegistryObject<Item> SMITHING_TONGS= ITEMS.register("smithing_tongs",()->new Item(new Item.Properties().stacksTo(1).durability(32)));

    public static final RegistryObject<Item> LARGE_IRON_BARREL= ITEMS.register("large_iron_barrel",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> LARGE_GUNMETAL_BARREL= ITEMS.register("large_gunmetal_barrel",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SMALL_IRON_BARREL= ITEMS.register("small_iron_barrel",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SMALL_GUNMETAL_BARREL = ITEMS.register("small_gunmetal_barrel",()->new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> GUN_TRIGGER = ITEMS.register("gun_trigger",()->new Item(new Item.Properties().stacksTo(64)));


    public static final RegistryObject<Item> SAGE = ITEMS.register("sage",
            ()-> new ItemNameBlockItem(MBBlocks.SAGE_CROP_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> YARROW = ITEMS.register("yarrow",
            ()-> new ItemNameBlockItem(MBBlocks.YARROW_CROP_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ARNICA = ITEMS.register("arnica",
            ()-> new ItemNameBlockItem(MBBlocks.ARNICA_CROP_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> LEMON_BALM = ITEMS.register("lemon_balm",
            ()-> new ItemNameBlockItem(MBBlocks.LEMON_BALM_CROP_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> COMFREY = ITEMS.register("comfrey",
            ()-> new ItemNameBlockItem(MBBlocks.COMFREY_CROP_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> YELLOW_WOOD_SORREL = ITEMS.register("yellow_wood_sorrel",
            ()-> new ItemNameBlockItem(MBBlocks.YELLOW_WOOD_SORREL_CROP_BLOCK.get(), new Item.Properties()));


    public static final RegistryObject<Item> HANDGONNE= ITEMS.register("handgonne",()->new HandGonneItem(new Item.Properties().stacksTo(1).durability(24)));
    public static final RegistryObject<Item> SPIKEHANDGONNE= ITEMS.register("spikedhandgonne",()->new SpikedHandGonneItem(new Item.Properties().stacksTo(1).durability(24)));

    public static final RegistryObject<Item> JAVELIN= ITEMS.register("javelin",()->new JavelinItem(new Item.Properties().stacksTo(1).durability(24)));
    public static final RegistryObject<Item> ARBALEST= ITEMS.register("arbalest",()->new ArbalestItem(new Item.Properties().stacksTo(1).durability(924)));
    public static final RegistryObject<Item> ARQUEBUS= ITEMS.register("arquebus",()->new ArquebusItem(new Item.Properties().stacksTo(1).durability(48)));

    public static final RegistryObject<Item> HEAVY_BOLT= ITEMS.register("heavy_bolt",()->new ArrowItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> ROUND_BALL= ITEMS.register("round_ball",()->new ArrowItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> IRON_THROWING_KNIFE= ITEMS.register("iron_throwing_knife",()->new ThrowingKnifeItem(new Item.Properties().stacksTo(1).durability(24)));
    public static final RegistryObject<Item> IRON_THROWING_AXE= ITEMS.register("iron_throwing_axe",()->new ThrowingAxeItem(new Item.Properties().stacksTo(1).durability(24)));

    public static final RegistryObject<Item> SMALL_THROWING_ROCK= ITEMS.register("small_throwing_rock",()->new ThrowingSmallRockItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LARGE_THROWING_ROCK= ITEMS.register("large_throwing_rock",()->new ThrowingLargeRockItem(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> MORNINGSTAR= ITEMS.register("morningstar",()->new MorningStarItem(new Item.Properties().stacksTo(1).durability(2048)));
    public static final RegistryObject<Item> GOTHEVENINGSTAR= ITEMS.register("gotheveningstar",()->new GotheveningStarItem(new Item.Properties().stacksTo(1).durability(4096)));
    public static final RegistryObject<Item> EVENINGSTAR= ITEMS.register("eveningstar",()->new EveningStarItem(new Item.Properties().stacksTo(1).durability(2048)));



    public static final RegistryObject<Item> THROWING_WARDART= ITEMS.register("war_dart",()->new WarDartItem(new Item.Properties().stacksTo(1).durability(16)));
    public static final RegistryObject<Item> RECURVE_BOW= ITEMS.register("recurve_bow",()->new BowItem(new Item.Properties().stacksTo(1)));


}
