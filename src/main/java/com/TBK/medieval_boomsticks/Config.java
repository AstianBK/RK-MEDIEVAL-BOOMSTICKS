package com.TBK.medieval_boomsticks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = RKMedievalBoomStick.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.DoubleValue ROUND_BALL_DAMAGE = BUILDER
            .comment("Round Ball ammo damage value")
            .defineInRange("round_ball_damage", 10.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue HEAVY_BOLT_DAMAGE = BUILDER
            .comment("Heavy Bolt ammo damage value")
            .defineInRange("heavy_bolt_damage", 4.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue JAVELIN_DAMAGE = BUILDER
            .comment("Javelin damage value")
            .defineInRange("javelin_damage", 8.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue SMALL_ROCK_DAMAGE = BUILDER
            .comment("Round Ball ammo damage value")
            .defineInRange("small_rock_damage", 4.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue WARDART_DAMAGE = BUILDER
            .comment("Round Ball ammo damage value")
            .defineInRange("wardart_damage", 10.0D, 0, Double.MAX_VALUE);


    private static final ForgeConfigSpec.DoubleValue THROWN_WARDART_DAMAGE = BUILDER
            .comment("Round Ball ammo damage value")
            .defineInRange("thrown_wardart_damage", 10.0D, 0, Double.MAX_VALUE);


    private static final ForgeConfigSpec.DoubleValue LARGE_ROCK_DAMAGE = BUILDER
            .comment("Heavy Bolt ammo damage value")
            .defineInRange("large_rock_damage", 18.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue THROWN_KNIFE_DAMAGE = BUILDER
            .comment("Knife Projectile damage value")
            .defineInRange("thrown_knife_damage", 8.0D, 0, Double.MAX_VALUE);
    private static final ForgeConfigSpec.DoubleValue THROWN_AXE_DAMAGE = BUILDER
            .comment("Axe Projectile damage value")
            .defineInRange("thrown_axe_damage", 8.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue KNIFE_DAMAGE = BUILDER
            .comment("Knife damage value")
            .defineInRange("knife_damage", 8.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue AXE_DAMAGE = BUILDER
            .comment("Axe damage value")
            .defineInRange("axe_damage", 8.0D, 0, Double.MAX_VALUE);


    private static final ForgeConfigSpec.DoubleValue SMALL_ROCK_SPEED = BUILDER
            .comment("Small Rock Projectile Speed")
            .defineInRange("small_rock_speed", 2.5D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue LARGE_ROCK_SPEED = BUILDER
            .comment("Large Rock Projectile Speed")
            .defineInRange("large_rock_speed", 1.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue JAVELIN_SPEED = BUILDER
            .comment("Javelin Projectile Speed Value")
            .defineInRange("javelin_speed", 2.5D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue ARMOR_PENETRATION_PERCENTAGE = BUILDER
            .comment("FireArm armor penetration percentage")
            .defineInRange("armor_penetration_percentage", 50, 0, 100);

    private static final ForgeConfigSpec.IntValue MAZE_ARMOR_PENETRATION_PERCENTAGE = BUILDER
            .comment("Mace armor penetration percentage")
            .defineInRange("maze_armor_penetration_percentage", 30, 0, 100);



    private static final ForgeConfigSpec.IntValue PROBABILITY_FAIL_FIREGUN = BUILDER
            .comment("Arquebus & Handgonne chance to fail a shot")
            .defineInRange("probability_fail_firegun", 5, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue COOLDOWN_ARQUEBUS = BUILDER
            .comment("Arquebus cooldown in seconds")
            .defineInRange("cooldown_arquebus", 15, 0, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue COOLDOWN_HANDGONNE = BUILDER
            .comment("Handgonne cooldown in seconds")
            .defineInRange("cooldown_handgonne", 15, 0, Integer.MAX_VALUE);


    private static final ForgeConfigSpec.DoubleValue RECHARGE_SPEED_ARQUEBUS = BUILDER
            .comment("Arquebus Recharge Speed")
            .defineInRange("recharge_speed_arquebus", 0.5D, 0, 2.0D);

    private static final ForgeConfigSpec.DoubleValue RECHARGE_SPEED_ARBALEST = BUILDER
            .comment("Arbalest Recharge Speed")
            .defineInRange("recharge_speed_arbalest", 1.0D, 0.0D, 2.0D);

    private static final ForgeConfigSpec.DoubleValue RECHARGE_SPEED_HANDGONNE = BUILDER
            .comment("Handgonne Recharge Speed")
            .defineInRange("recharge_speed_handgonne", 0.5D, 0.0D, 2.0D);

    private static final ForgeConfigSpec.DoubleValue RECHARGE_SPEED_SPIKEDHANDGONNE = BUILDER
            .comment("SpikedHandgonne Recharge Speed")
            .defineInRange("recharge_speed_spikedhandgonne", 1.0D, 0.0D, 2.0D);

    private static final ForgeConfigSpec.DoubleValue SMALL_CALIBER_DAMAGE = BUILDER
            .comment("Arquebus Recharge Speed")
            .defineInRange("small_caliber_damage", 10D, 0,  Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue MEDIUM_CALIBER_DAMAGE = BUILDER
            .comment("Arquebus Recharge Speed")
            .defineInRange("medium_caliber_damage", 15D, 0, Double.MAX_VALUE);
    private static final ForgeConfigSpec.DoubleValue HEAVY_CALIBER_DAMAGE = BUILDER
            .comment("Arquebus Recharge Speed")
            .defineInRange("heavy_caliber_damage", 20D, 0,  Double.MAX_VALUE);

    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> SMALL_CALIBER = BUILDER
            .comment("A blacklist for armors that can't be chainmailed")
            .defineListAllowEmpty("small_caliber", new ArrayList<>(), Config::validateItemName);

    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> MEDIUM_CALIBER = BUILDER
            .comment("A blacklist for armors that can't be chainmailed")
            .defineListAllowEmpty("medium_caliber", List.of("medieval_boomsticks:handgonne","medieval_boomsticks:spikehandgonne","medieval_boomsticks:arquebus"), Config::validateItemName);

    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> HEAVY_CALIBER = BUILDER
            .comment("A blacklist for armors that can't be chainmailed")
            .defineListAllowEmpty("heavy_caliber", new ArrayList<>(), Config::validateItemName);

    private static boolean validateItemName(final Object obj) {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }


    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static List<Item> smallCaliberList;

    public static List<Item> mediumCaliberList;
    public static List<Item> heavyCaliberList;

    public static double roundBallDamage;
    public static double heavyBoltDamage;
    public static double javelinDamage;
    public static double smallCaliberDamage;
    public static double mediumCaliberDamage;
    public static double heavyCaliberDamage;

    public static double axeDamage;
    public static double knifeDamage;
    public static double thrownKnifeDamage;
    public static double thrownAxeDamage;
    public static double smallRockDamage;
    public static double largeRockDamage;

    public static double javelinSpeed;
    public static double smallRockSpeed;

    public static double largeRockSpeed;

    public static int probabilityFail;

    public static int armorPenetrationPercentage;

    public static int mazeArmorPenetrationPercentage;

    public static int cooldownArquebus;

    public static int cooldownHandgonne;

    public static Double rechargeSpeedSpikedHandgonne;

    public static Double rechargeSpeedArquebus;
    public static Double rechargeSpeedArbalest;
    public static Double rechargeSpeedHandgonne;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        roundBallDamage = ROUND_BALL_DAMAGE.get();
        heavyBoltDamage = HEAVY_BOLT_DAMAGE.get();
        axeDamage =AXE_DAMAGE.get();
        knifeDamage=KNIFE_DAMAGE.get();
        thrownAxeDamage =THROWN_AXE_DAMAGE.get();
        thrownKnifeDamage=THROWN_KNIFE_DAMAGE.get();
        smallRockDamage =SMALL_ROCK_DAMAGE.get();
        largeRockDamage=LARGE_ROCK_DAMAGE.get();

        javelinSpeed = JAVELIN_SPEED.get();
        smallRockSpeed = SMALL_ROCK_SPEED.get();
        largeRockSpeed =LARGE_ROCK_SPEED.get();
        probabilityFail = PROBABILITY_FAIL_FIREGUN.get();
        rechargeSpeedArquebus = RECHARGE_SPEED_ARQUEBUS.get();
        rechargeSpeedArbalest = RECHARGE_SPEED_ARBALEST.get();
        rechargeSpeedHandgonne = RECHARGE_SPEED_HANDGONNE.get();
        rechargeSpeedSpikedHandgonne = RECHARGE_SPEED_SPIKEDHANDGONNE.get();
        cooldownArquebus = COOLDOWN_ARQUEBUS.get();
        cooldownHandgonne = COOLDOWN_HANDGONNE.get();
        armorPenetrationPercentage = ARMOR_PENETRATION_PERCENTAGE.get();
        mazeArmorPenetrationPercentage = MAZE_ARMOR_PENETRATION_PERCENTAGE.get();
        javelinDamage= JAVELIN_DAMAGE.get();

        smallCaliberDamage = SMALL_CALIBER_DAMAGE.get();
        mediumCaliberDamage = MEDIUM_CALIBER_DAMAGE.get();
        heavyCaliberDamage = HEAVY_CALIBER_DAMAGE.get();

        smallCaliberList = SMALL_CALIBER.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                .collect(Collectors.toList());

        mediumCaliberList = MEDIUM_CALIBER.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                .collect(Collectors.toList());

        heavyCaliberList = HEAVY_CALIBER.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                .collect(Collectors.toList());

    }
}
