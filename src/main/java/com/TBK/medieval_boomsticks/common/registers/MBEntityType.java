package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.server.entity.HeavyBoltProjectile;
import com.TBK.medieval_boomsticks.server.entity.RoundBallProjectile;
import com.TBK.medieval_boomsticks.server.entity.ThrownJavelin;
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

    public static final RegistryObject<EntityType<RoundBallProjectile>> ROUND_BALL = ENTITY_TYPES
            .register("round_ball", () -> EntityType.Builder.<RoundBallProjectile>of(RoundBallProjectile::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "round_ball"));

    public static final RegistryObject<EntityType<HeavyBoltProjectile>> HEAVY_BOLT = ENTITY_TYPES
            .register("heavy_bolt", () -> EntityType.Builder.<HeavyBoltProjectile>of(HeavyBoltProjectile::new, MobCategory.MISC)
                    .fireImmune().sized(0.2F, 0.2F).build(RKMedievalBoomStick.MODID + "heavy_bolt"));

}
