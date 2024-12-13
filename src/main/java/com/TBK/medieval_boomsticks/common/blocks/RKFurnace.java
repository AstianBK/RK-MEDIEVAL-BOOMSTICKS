package com.TBK.medieval_boomsticks.common.blocks;

import com.TBK.medieval_boomsticks.common.RKFurnaceEntity;
import com.TBK.medieval_boomsticks.common.registers.MBBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class RKFurnace extends AbstractFurnaceBlock {
    public RKFurnace(Properties p_48687_) {
        super(p_48687_);
    }

    protected void openContainer(Level p_49777_, BlockPos p_49778_, Player p_49779_) {
        BlockEntity blockentity = p_49777_.getBlockEntity(p_49778_);
        if (blockentity instanceof RKFurnaceEntity) {
            p_49779_.openMenu((MenuProvider)blockentity);
            p_49779_.awardStat(Stats.INTERACT_WITH_BLAST_FURNACE);
        }
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return createTickerHelper(p_153212_,p_153214_, MBBlockEntity.RK_FURNACE_ENTITY.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new RKFurnaceEntity(p_153215_,p_153216_);
    }


    private static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(Level p_151988_, BlockEntityType<T> p_151989_, BlockEntityType<? extends RKFurnaceEntity> p_151990_) {
        return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, p_151990_, RKFurnaceEntity::serverTicks);
    }
}
