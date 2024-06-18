package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.ArbalestModel;
import com.TBK.medieval_boomsticks.client.model.ArquebusModel;
import com.TBK.medieval_boomsticks.common.items.ArbalestItem;
import com.TBK.medieval_boomsticks.common.items.ArquebusItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ArbalestRenderer<T extends ArbalestItem> extends GeoItemRenderer<T> {
    public ArbalestRenderer() {
        super(new ArbalestModel<>());
    }

    @Override
    public RenderType getRenderType(T animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.itemEntityTranslucentCull(texture);
    }
}
