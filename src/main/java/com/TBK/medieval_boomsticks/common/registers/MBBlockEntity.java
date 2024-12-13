package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.RKFurnaceEntity;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MBBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITY =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RKMedievalBoomStick.MODID);

    public static final RegistryObject<BlockEntityType<RKFurnaceEntity>> RK_FURNACE_ENTITY =
            BLOCKS_ENTITY.register("rk_furnace_entity", () ->
                    BlockEntityType.Builder.of(RKFurnaceEntity::new,
                            MBBlocks.RK_FURNACE.get()).build(null));
}
