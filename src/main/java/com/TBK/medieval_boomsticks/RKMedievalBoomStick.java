package com.TBK.medieval_boomsticks;

import com.TBK.medieval_boomsticks.client.gui.RKFurnaceScreenMenu;
import com.TBK.medieval_boomsticks.client.renderer.*;
import com.TBK.medieval_boomsticks.common.registers.*;
import com.TBK.medieval_boomsticks.server.data.MBGenWorld;
import com.TBK.medieval_boomsticks.server.network.PacketHandler;
import com.TBK.medieval_boomsticks.server.world.BKBlockStateProvider;
import com.TBK.medieval_boomsticks.server.world.BKLootTableProvider;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RKMedievalBoomStick.MODID)
public class RKMedievalBoomStick
{
    public static final String MODID = "medieval_boomsticks";
    public static final Logger LOGGER = LogUtils.getLogger();
    public RKMedievalBoomStick()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        MBBlocks.BLOCKS.register(modEventBus);
        MBItems.ITEMS.register(modEventBus);
        MBEntityType.ENTITY_TYPES.register(modEventBus);
        MBCreativeTabs.TABS.register(modEventBus);
        MBSounds.register(modEventBus);
        MBRecipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);
        MBRecipeSerializer.RECIPE_TYPES.register(modEventBus);
        MBMenuType.MENU_TYPE.register(modEventBus);
        MBBlockEntity.BLOCKS_ENTITY.register(modEventBus);
        PacketHandler.registerMessages();
        MinecraftForge.EVENT_BUS.register(this);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,()->()->{
            modEventBus.addListener(this::registerRenderers);
        });
        modEventBus.addListener(this::dataSetup);

    }

    @OnlyIn(Dist.CLIENT)
    private void registerRenderers(FMLCommonSetupEvent event){
        EntityRenderers.register(MBEntityType.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
        EntityRenderers.register(MBEntityType.THROWN_KNIFE.get(), ThrownKnifeRenderer::new);
        EntityRenderers.register(MBEntityType.THROWN_AXE.get(), ThrownAxeRenderer::new);
        EntityRenderers.register(MBEntityType.THROWN_WARDART.get(), ThrownWarDartRenderer::new);
        EntityRenderers.register(MBEntityType.THROWN_SMALL_ROCK.get(), ThrownSmallRockRenderer::new);
        EntityRenderers.register(MBEntityType.THROWN_LARGE_ROCK.get(), ThrownLargeRockRenderer::new);
        EntityRenderers.register(MBEntityType.ROUND_BALL.get(), RoundBallRenderer::new);
        EntityRenderers.register(MBEntityType.HEAVY_BOLT.get(), HeavyBoltRenderer::new);
        MenuScreens.register(MBMenuType.FURNACE_MENU.get(), RKFurnaceScreenMenu::new);

    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();
        boolean includeServer = event.includeServer();
        generator.addProvider(includeServer, BKLootTableProvider.create(packOutput));
        generator.addProvider(event.includeClient(), new BKBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(includeServer,new MBGenWorld(packOutput,event.getLookupProvider()));
    }
}
