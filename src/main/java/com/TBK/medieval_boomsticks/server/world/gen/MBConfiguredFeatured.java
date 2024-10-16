package com.TBK.medieval_boomsticks.server.world.gen;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.registers.MBBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class MBConfiguredFeatured {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SAPPHIRE_ORE_KEY = registerKey("mb_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SAPPHIRE_ORE_KEY = registerKey("mb_ore_1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_SAPPHIRE_ORE_KEY = registerKey("mb_ore_2");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> ore = List.of(OreConfiguration.target(stoneReplaceable,
                        MBBlocks.MB_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, MBBlocks.MB_ORE_DEEPSLATE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> ore1 = List.of(OreConfiguration.target(stoneReplaceable,
                        MBBlocks.MB_ORE_1.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, MBBlocks.MB_ORE_1_DEEPSLATE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> ore2 = List.of(OreConfiguration.target(stoneReplaceable,
                        MBBlocks.MB_ORE_2.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, MBBlocks.MB_ORE_2_DEEPSLATE.get().defaultBlockState()));

        register(context, OVERWORLD_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(ore, 9));
        register(context, NETHER_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(ore1, 9));
        register(context, END_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(ore2, 9));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(RKMedievalBoomStick.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
