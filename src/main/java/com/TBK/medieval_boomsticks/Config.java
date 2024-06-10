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

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static double roundBallDamage;
    public static double heavyBoltDamage;



    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        roundBallDamage = ROUND_BALL_DAMAGE.get();
        heavyBoltDamage = HEAVY_BOLT_DAMAGE.get();
    }
}
