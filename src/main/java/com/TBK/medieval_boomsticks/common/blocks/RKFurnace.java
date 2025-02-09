package com.TBK.medieval_boomsticks.common.blocks;

import com.TBK.medieval_boomsticks.common.RKFurnaceEntity;
import com.TBK.medieval_boomsticks.common.registers.MBBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class RKFurnace extends AbstractFurnaceBlock {
    protected static final VoxelShape AXIS_AABB = Block.box(0.0D, 0.0D, 0.0D,
            16.0D, 16.0D, 16.0D);
    protected static final VoxelShape CHIMNEY = Block.box(4, 3, 4,
            12, 13, 12);
    protected static final VoxelShape BASE_SOUTH = Block.box(3, 0, 3, 13, 5, 16);
    protected static final VoxelShape BASE_LEFT_SOUTH = Block.box(0, 0, 3, 3, 3, 16);
    protected static final VoxelShape BASE_RIGHT_SOUTH = Block.box(13, 0, 3, 16, 3, 16);

    // NORTE
    protected static final VoxelShape BASE_NORTH = Block.box(3, 0, 0, 13, 5, 13);
    protected static final VoxelShape BASE_LEFT_NORTH = Block.box(13, 0, 0, 16, 3, 13);
    protected static final VoxelShape BASE_RIGHT_NORTH = Block.box(0, 0, 0, 3, 3, 13);

    // ESTE
    protected static final VoxelShape BASE_EAST = Block.box(3, 0, 3, 16, 5, 13);
    protected static final VoxelShape BASE_LEFT_EAST = Block.box(3, 0, 0, 16, 3, 3);
    protected static final VoxelShape BASE_RIGHT_EAST = Block.box(3, 0, 13, 16, 3, 16);

    // OESTE
    protected static final VoxelShape BASE_WEST = Block.box(0, 0, 3, 13, 5, 13);
    protected static final VoxelShape BASE_LEFT_WEST = Block.box(0, 0, 0, 3, 3, 3);
    protected static final VoxelShape BASE_RIGHT_WEST = Block.box(0, 0, 13, 3, 3, 16);
    protected static final VoxelShape AXIS_AABB_SOUTH = Shapes.or(BASE_SOUTH,BASE_LEFT_SOUTH,BASE_RIGHT_SOUTH,CHIMNEY);
    protected static final VoxelShape AXIS_AABB_NORTH = Shapes.or(BASE_NORTH,BASE_LEFT_NORTH,BASE_RIGHT_NORTH,CHIMNEY);
    protected static final VoxelShape AXIS_AABB_EAST = Shapes.or(BASE_EAST,BASE_LEFT_EAST,BASE_RIGHT_EAST,CHIMNEY);
    protected static final VoxelShape AXIS_AABB_WEST = Shapes.or(BASE_WEST,BASE_LEFT_WEST,BASE_RIGHT_WEST,CHIMNEY);

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;


    public RKFurnace(Properties p_48687_) {
        super(p_48687_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return p_60555_.getValue(HALF)==DoubleBlockHalf.UPPER ? this.getShapeForDirection(p_60555_.getValue(FACING)) : AXIS_AABB;
    }

    public VoxelShape getShapeForDirection(Direction direction){
        return switch (direction) {
            case NORTH -> AXIS_AABB_SOUTH;
            case EAST  -> AXIS_AABB_WEST;
            case SOUTH -> AXIS_AABB_NORTH;
            case WEST  -> AXIS_AABB_EAST;
            default -> BASE_SOUTH;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return p_60572_.getValue(HALF)==DoubleBlockHalf.UPPER ? this.getShapeForDirection(p_60572_.getValue(FACING)) : AXIS_AABB;
    }


    public void animateTick(BlockState p_221253_, Level p_221254_, BlockPos p_221255_, RandomSource p_221256_) {
        if (p_221253_.getValue(LIT) && p_221253_.getValue(HALF)==DoubleBlockHalf.LOWER) {
            double d0 = (double)p_221255_.getX() + 0.5D;
            double d1 = (double)p_221255_.getY() + 0.75D;
            double d2 = (double)p_221255_.getZ() + 0.5D;
            if (p_221256_.nextDouble() < 0.1D) {
                p_221254_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = p_221253_.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = p_221256_.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
            double d6 = p_221256_.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
            p_221254_.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            p_221254_.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
            if (p_221256_.nextDouble()<0.4D){
                p_221254_.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,d0, (double)p_221255_.getY()+2.2D, d2, 0.0D, 0.1D, 0.0D);
            }
        }
    }

    protected void openContainer(Level p_49777_, BlockPos p_49778_, Player p_49779_) {
        BlockState state=p_49777_.getBlockState(p_49778_);
        BlockEntity blockentity = p_49777_.getBlockEntity(state.getValue(HALF)==DoubleBlockHalf.LOWER ? p_49778_ : p_49778_.below());
        if (blockentity instanceof RKFurnaceEntity) {
            p_49779_.openMenu((MenuProvider)blockentity);
            p_49779_.awardStat(Stats.INTERACT_WITH_BLAST_FURNACE);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return super.getStateForPlacement(p_48689_).setValue(HALF,DoubleBlockHalf.LOWER);
    }

    @Override
    public void destroy(LevelAccessor p_49860_, BlockPos p_49861_, BlockState p_49862_) {
        if(!p_49860_.isClientSide()){
            if(p_49862_.getValue(HALF)==DoubleBlockHalf.LOWER){
                p_49860_.destroyBlock(p_49861_.above(),true);
            }else {
                p_49860_.destroyBlock(p_49861_.below(),true);
            }
        }
        super.destroy(p_49860_, p_49861_, p_49862_);

    }



    @Override
    public void setPlacedBy(Level p_48694_, BlockPos p_48695_, BlockState p_48696_, LivingEntity p_48697_, ItemStack p_48698_) {
        if(!p_48694_.isClientSide){
            p_48694_.setBlock(p_48695_.above(),this.defaultBlockState().setValue(HALF,DoubleBlockHalf.UPPER).setValue(FACING,p_48696_.getValue(FACING)),3);
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
        return p_153216_.getValue(HALF)==DoubleBlockHalf.LOWER ? new RKFurnaceEntity(p_153215_,p_153216_) : null;
    }


    private static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(Level p_151988_, BlockEntityType<T> p_151989_, BlockEntityType<? extends RKFurnaceEntity> p_151990_) {
        return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, p_151990_, RKFurnaceEntity::serverTicks);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
        super.createBlockStateDefinition(p_48725_);
        p_48725_.add(HALF);
    }
}
