package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.server.entity.HeavyBoltProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class HeavyBoltRenderer extends ArrowRenderer<HeavyBoltProjectile> {

    private final ResourceLocation TEXTURE=new ResourceLocation("textures/entity/projectiles/arrow.png");

    public HeavyBoltRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    public ResourceLocation getTextureLocation(@NotNull HeavyBoltProjectile pEntity) {
        return TEXTURE;
    }
}