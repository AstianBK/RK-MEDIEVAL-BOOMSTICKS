package com.TBK.medieval_boomsticks.server.network.msg;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.Random;
import java.util.function.Supplier;


public class PacketSmokeEffect {
    private final double x;
    private final double y;
    private final double z;
    private final boolean isFail;

    public PacketSmokeEffect(FriendlyByteBuf buf) {
        Minecraft mc = Minecraft.getInstance();
        assert mc.level != null;
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
        this.isFail = buf.readBoolean();
    }

    public PacketSmokeEffect(double x,double y,double z,boolean isFail){
        this.x = x;
        this.y = y;
        this.z = z;
        this.isFail=isFail;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
        buf.writeBoolean(isFail);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() ->{
            assert context.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT;
            handlePlayActivateAnimation();
        });
        context.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private void handlePlayActivateAnimation() {
        Minecraft mc = Minecraft.getInstance();
        for(int i=0;i<5;i++){
            Particle particleOptions= mc.particleEngine.createParticle(ParticleTypes.POOF,x,y,z,0.0f,0.01f,0.0f);
            assert particleOptions!=null;
            particleOptions.setPos(x,y,z);
            if(isFail){
                particleOptions.setColor(0,0,0);
            }
        }

    }
}