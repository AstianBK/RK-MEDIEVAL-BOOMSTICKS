package com.TBK.medieval_boomsticks.common.registers;
import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.blocks.*;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MBBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RKMedievalBoomStick.MODID);

    public static final RegistryObject<Block> MB_ORE = registerBlock("mb_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> MB_ORE_1 = registerBlock("mb_ore_1",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> MB_ORE_2 = registerBlock("mb_ore_2",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> MB_ORE_DEEPSLATE = registerBlock("mb_ore_deepslate",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> MB_ORE_1_DEEPSLATE = registerBlock("mb_ore_1_deepslate",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> MB_ORE_2_DEEPSLATE = registerBlock("mb_ore_2_deepslate",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> SAGE_CROP_BLOCK = BLOCKS.register("sage_crop_block",
            () -> new SageCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));

    public static final RegistryObject<Block> YARROW_CROP_BLOCK = BLOCKS.register("yarrow_crop_block",
            () -> new YarrowCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> ARNICA_CROP_BLOCK = BLOCKS.register("arnica_crop_block",
            () -> new ArnicaCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));

    public static final RegistryObject<Block> YELLOW_WOOD_SORREL_CROP_BLOCK = BLOCKS.register("yellow_wood_sorrel_crop_block",
            () -> new YellowWoodSorrelCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> COMFREY_CROP_BLOCK = BLOCKS.register("comfrey_crop_block",
            () -> new ComfreyCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));

    public static final RegistryObject<Block> LEMON_BALM_CROP_BLOCK = BLOCKS.register("lemon_balm_crop_block",
            () -> new LemonBalmCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block) {
        MBItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
