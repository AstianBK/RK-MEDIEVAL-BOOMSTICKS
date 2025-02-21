package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BullatItem extends ArrowItem {
    public final Caliber caliber;
    public BullatItem(Properties p_40512_,Caliber caliber) {
        super(p_40512_);
        this.caliber=caliber;
    }

    public Caliber getCaliber(){
        return this.caliber;
    }

    public void appendHoverText(ItemStack p_40880_, @Nullable Level p_40881_, List<Component> p_40882_, TooltipFlag p_40883_) {
        p_40882_.add(this.caliber.getCaliberName().withStyle(ChatFormatting.GRAY));
    }


    public enum Caliber{
        SMALL(),
        MEDIUM(),
        HEAVY();

        Caliber(){
        }

        public double getDamage(){
            switch (this){
                case SMALL -> {
                    return Config.smallCaliberDamage;
                }
                case MEDIUM -> {
                    return Config.mediumCaliberDamage;
                }
                case HEAVY -> {
                    return Config.heavyCaliberDamage;
                }
            }
            return 0.0D;
        }
        public MutableComponent getCaliberName(){
            if(this==SMALL){
                return Component.translatable("item.medieval_boomsticks.caliber.small_caliber");
            }else if(this==MEDIUM){
                return Component.translatable("item.medieval_boomsticks.caliber.medium_caliber");
            }else if(this==HEAVY){
                return Component.translatable("item.medieval_boomsticks.caliber.heavy_caliber");
            }
            return Component.literal("NONE");
        }
    }
}
