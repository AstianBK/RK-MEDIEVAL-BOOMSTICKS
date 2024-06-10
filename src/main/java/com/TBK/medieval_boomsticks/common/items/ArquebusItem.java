package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.client.renderer.ArquebusRenderers;
import com.TBK.medieval_boomsticks.client.renderer.HandGonneRenderers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ArquebusItem extends FireGunItem{
    public ArquebusItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new ArquebusRenderers<>();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }
}
