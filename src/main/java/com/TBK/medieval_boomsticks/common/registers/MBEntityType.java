package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.server.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MBEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RKMedievalBoomStick.MODID);


    public static final RegistryObject<EntityType<ThrownJavelin>> THROWN_JAVELIN = ENTITY_TYPES
            .register("thrown_javelin", () -> EntityType.Builder.<ThrownJavelin>of(ThrownJavelin::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "thrown_javelin"));

    public static final RegistryObject<EntityType<ThrowableWardart>> THROWN_WARDART = ENTITY_TYPES
            .register("thrown_wardart", () -> EntityType.Builder.<ThrowableWardart>of(ThrowableWardart::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "thrown_wardart"));

    public static final RegistryObject<EntityType<ThrowableKnife>> THROWN_KNIFE = ENTITY_TYPES
            .register("thrown_knife", () -> EntityType.Builder.<ThrowableKnife>of(ThrowableKnife::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "thrown_knife"));


    public static final RegistryObject<EntityType<ThrowableAxe>> THROWN_AXE = ENTITY_TYPES
            .register("thrown_axe", () -> EntityType.Builder.<ThrowableAxe>of(ThrowableAxe::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "thrown_axe"));

    public static final RegistryObject<EntityType<ThrowableSmallRock>> THROWN_SMALL_ROCK = ENTITY_TYPES
            .register("thrown_small_rock", () -> EntityType.Builder.<ThrowableSmallRock>of(ThrowableSmallRock::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "thrown_small_rock"));

    public static final RegistryObject<EntityType<ThrowableLargeRock>> THROWN_LARGE_ROCK = ENTITY_TYPES
            .register("thrown_large_rock", () -> EntityType.Builder.<ThrowableLargeRock>of(ThrowableLargeRock::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "thrown_large_rock"));

    public static final RegistryObject<EntityType<RoundBallProjectile>> ROUND_BALL = ENTITY_TYPES
            .register("round_ball", () -> EntityType.Builder.<RoundBallProjectile>of(RoundBallProjectile::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "round_ball"));

    public static final RegistryObject<EntityType<HeavyBoltProjectile>> HEAVY_BOLT = ENTITY_TYPES
            .register("heavy_bolt", () -> EntityType.Builder.<HeavyBoltProjectile>of(HeavyBoltProjectile::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "heavy_bolt"));

}
