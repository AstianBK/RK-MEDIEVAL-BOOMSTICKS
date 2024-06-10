package com.TBK.medieval_boomsticks;

import com.TBK.medieval_boomsticks.client.renderer.ThrownJavelinRenderer;
import com.TBK.medieval_boomsticks.common.registers.MBEntityType;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
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
    private static final Logger LOGGER = LogUtils.getLogger();
    public RKMedievalBoomStick()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MBItems.ITEMS.register(modEventBus);
        MBEntityType.ENTITY_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);


        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,()->()->{
            modEventBus.addListener(this::registerRenderers);
        });
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @OnlyIn(Dist.CLIENT)
    private void registerRenderers(FMLCommonSetupEvent event){
        EntityRenderers.register(MBEntityType.THROWN_JAVELIN.get(), ThrownJavelinRenderer::new);
    }


}
