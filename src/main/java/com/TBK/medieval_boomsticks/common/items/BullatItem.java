package com.TBK.medieval_boomsticks.common.items;

import com.TBK.medieval_boomsticks.Config;
import net.minecraft.world.item.ArrowItem;

public class BullatItem extends ArrowItem {
    public final Caliber caliber;
    public BullatItem(Properties p_40512_,Caliber caliber) {
        super(p_40512_);
        this.caliber=caliber;
    }

    public Caliber getCaliber(){
        return this.caliber;
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
    }
}
