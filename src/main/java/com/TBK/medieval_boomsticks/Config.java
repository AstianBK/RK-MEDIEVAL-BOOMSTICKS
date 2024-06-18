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
            .comment("A magic number")
            .defineInRange("round_ball_damage", 2.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue HEAVY_BOLT_DAMAGE = BUILDER
            .comment("A magic number")
            .defineInRange("heavy_bolt_damage", 2.0D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue JAVELIN_SPEED = BUILDER
            .comment("A magic number")
            .defineInRange("javelin_speed", 2.5D, 0, Double.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue PROBABILITY_FAIL_FIREGUN = BUILDER
            .comment("A magic number")
            .defineInRange("probability_fail_firegun", 5, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.DoubleValue RECHARGE_SPEED_ARQUEBUS = BUILDER
            .comment("A magic number")
            .defineInRange("recharge_speed_arquebus", 1.0D, 0, 2.0D);

    private static final ForgeConfigSpec.DoubleValue RECHARGE_SPEED_ARBALEST = BUILDER
            .comment("A magic number")
            .defineInRange("recharge_speed_arbalest", 1.0D, 0, 2.0D);

    private static final ForgeConfigSpec.DoubleValue RECHARGE_SPEED_HANDGONNE = BUILDER
            .comment("A magic number")
            .defineInRange("recharge_speed_handgonne", 1.0D, 0, 2.0D);



    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static double roundBallDamage;
    public static double heavyBoltDamage;
    public static double javelinSpeed;

    public static int probabilityFail;

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
    }
}
