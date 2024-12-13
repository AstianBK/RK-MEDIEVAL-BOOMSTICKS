package com.TBK.medieval_boomsticks.client.gui;

import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@OnlyIn(Dist.CLIENT)
public class RKFurnaceRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {
    @Nullable
    private Ingredient fuels;

    protected Set<Item> getFuelItems() {
        return AbstractFurnaceBlockEntity.getFuel().keySet();
    }


    public void setupGhostRecipe(Recipe<?> p_100122_, List<Slot> p_100123_) {

    }
}
