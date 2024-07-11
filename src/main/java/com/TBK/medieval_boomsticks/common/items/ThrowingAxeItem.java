package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.client.renderer.AxeRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ThrowingAxeItem extends ThrowingItem {
    public boolean isCursed = false;
    public ThrowingAxeItem(Properties p_41383_) {
        super(p_41383_,ThrowableItems.AXE);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = new AxeRenderer<>();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return renderer;
            }
        });
    }

    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        if(p_41406_ instanceof Player){
            if(p_41404_.getItem()   instanceof ThrowingAxeItem axeItem){
                this.setCursed(p_41404_.getOrCreateTag(),p_41404_.getHoverName().getString().equals("Cursed"));
            }
        }
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
    }

    public void setCursed(CompoundTag tag, boolean isCursed){
        this.isCursed=isCursed;
        tag.putBoolean("isCursed",isCursed);
    }

    public void setCursed(boolean isCursed){
        this.isCursed= isCursed;
    }

    public boolean isCursed(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTag();
        if(tag.contains("isCursed")){
            return tag.getBoolean("isCursed");
        }
        return false;
    }
    public boolean isCursed(){
        return this.isCursed;
    }
}
