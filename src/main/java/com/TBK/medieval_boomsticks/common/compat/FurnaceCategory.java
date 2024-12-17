package com.TBK.medieval_boomsticks.common.compat;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.client.gui.FuelSlot;
import com.TBK.medieval_boomsticks.common.blocks.RKFurnace;
import com.TBK.medieval_boomsticks.common.registers.MBBlocks;
import com.TBK.medieval_boomsticks.common.registers.MBItems;
import com.TBK.medieval_boomsticks.server.data.recipe.RKFurnaceRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.FurnaceResultSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;

public class FurnaceCategory implements IRecipeCategory<RKFurnaceRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(RKMedievalBoomStick.MODID, "rk_furnace");
    private static final ResourceLocation TEXTURE = new ResourceLocation(RKMedievalBoomStick.MODID,"textures/gui/smithing_furnace.png");

    public static final mezz.jei.api.recipe.RecipeType<RKFurnaceRecipe> FURNACE_TYPE =
            new mezz.jei.api.recipe.RecipeType<>(UID, RKFurnaceRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;


    public FurnaceCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MBBlocks.SMITHING_FURNACE.get()));
    }
    @Override
    public RecipeType<RKFurnaceRecipe> getRecipeType() {
        return FURNACE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.medieval_boomsticks.smithing_furnace");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RKFurnaceRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,8, 9).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,8, 31).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,8, 53).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.INPUT,89, 53).addItemStacks(List.of(new ItemStack(Items.COAL),new ItemStack(Items.CHARCOAL)));


        builder.addSlot(RecipeIngredientRole.INPUT,152, 9).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT,152, 31).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT,152, 53).addIngredients(recipe.getIngredients().get(5));

        builder.addSlot(RecipeIngredientRole.OUTPUT,88, 13).addItemStack(recipe.getResultItem(null));
    }
}
