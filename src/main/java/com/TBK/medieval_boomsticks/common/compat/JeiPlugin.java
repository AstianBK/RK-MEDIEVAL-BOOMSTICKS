package com.TBK.medieval_boomsticks.common.compat;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.client.gui.RKFurnaceScreenMenu;
import com.TBK.medieval_boomsticks.common.registers.MBRecipeSerializer;
import com.TBK.medieval_boomsticks.server.data.recipe.RKFurnaceRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(RKMedievalBoomStick.MODID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FurnaceCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<RKFurnaceRecipe> polishingRecipes = recipeManager.getAllRecipesFor(MBRecipeSerializer.FURNACE_RECIPE_TYPE.get());
        registration.addRecipes(FurnaceCategory.FURNACE_TYPE, polishingRecipes);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(RKFurnaceScreenMenu.class, 60, 30, 20, 30,
                FurnaceCategory.FURNACE_TYPE);
    }
}
