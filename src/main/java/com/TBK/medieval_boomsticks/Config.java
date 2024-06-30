package com.TBK.medieval_boomsticks;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

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
            .defineInRange("small_rock_damage", 10.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue WARDART_DAMAGE = BUILDER
            .comment("Round Ball ammo damage value")
            .defineInRange("wardart_damage", 10.0D, 0, Double.MAX_VALUE);


    private static final ForgeConfigSpec.DoubleValue THROWN_WARDART_DAMAGE = BUILDER
            .comment("Round Ball ammo damage value")
            .defineInRange("thrown_wardart_damage", 10.0D, 0, Double.MAX_VALUE);


    private static final ForgeConfigSpec.DoubleValue LARGE_ROCK_DAMAGE = BUILDER
            .comment("Heavy Bolt ammo damage value")
            .defineInRange("large_rock_damage", 4.0D, 0, Double.MAX_VALUE);

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
            .comment("Knife damage value")
            .defineInRange("knife_damage", 8.0D, 0, Double.MAX_VALUE);


    private static final ForgeConfigSpec.DoubleValue SMALL_ROCK_SPEED = BUILDER
            .comment("Small Rock Projectile Speed")
            .defineInRange("small_rock_speed", 2.5D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue LARGE_ROCK_SPEED = BUILDER
            .comment("Large Rock Projectile Speed")
            .defineInRange("large_rock_speed", 2.5D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue JAVELIN_SPEED = BUILDER
            .comment("Javelin Projectile Speed")
            .defineInRange("javelin_speed", 2.5D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue ARMOR_PENETRATION_PERCENTAGE = BUILDER
            .comment("FireArm armor penetration percentage")
            .defineInRange("armor_penetration_percentage", 50, 0, 100);


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



    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static double roundBallDamage;
    public static double heavyBoltDamage;
    public static double javelinDamage;

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


    public static int cooldownArquebus;

    public static int cooldownHandgonne;

    public static Double rechargeSpeedArquebus;
    public static Double rechargeSpeedArbalest;
    public static Double rechargeSpeedHandgonne;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        roundBallDamage = ROUND_BALL_DAMAGE.get();
        heavyBoltDamage = HEAVY_BOLT_DAMAGE.get();
        javelinSpeed = JAVELIN_SPEED.get();
        probabilityFail = PROBABILITY_FAIL_FIREGUN.get();
        rechargeSpeedArquebus = RECHARGE_SPEED_ARQUEBUS.get();
        rechargeSpeedArbalest = RECHARGE_SPEED_ARBALEST.get();
        rechargeSpeedHandgonne = RECHARGE_SPEED_HANDGONNE.get();
        cooldownArquebus = COOLDOWN_ARQUEBUS.get();
        cooldownHandgonne = COOLDOWN_HANDGONNE.get();
        armorPenetrationPercentage = ARMOR_PENETRATION_PERCENTAGE.get();
        javelinDamage= JAVELIN_DAMAGE.get();
    }
}
