package com.TBK.medieval_boomsticks.client.renderer;

import com.TBK.medieval_boomsticks.client.model.RoundBallModel;
import com.TBK.medieval_boomsticks.server.entity.RoundBallProjectile;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RoundBallRenderers<T extends RoundBallProjectile> extends GeoEntityRenderer<T> {
    public RoundBallRenderers(EntityRendererProvider.Context renderManager) {
        super(renderManager,new RoundBallModel<>());
    }
}
