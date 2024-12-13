package com.TBK.medieval_boomsticks.common.registers;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.server.data.recipe.RKFurnaceRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MBRecipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RKMedievalBoomStick.MODID);

    public static final RegistryObject<RecipeSerializer<RKFurnaceRecipe>> NEW_FURNACE_RECIPE = RECIPE_SERIALIZERS.register("new_furnace_recipe", RKFurnaceRecipe.Serializer::new);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, RKMedievalBoomStick.MODID);

    public static final RegistryObject<RecipeType<RKFurnaceRecipe>> FURNACE_RECIPE_TYPE = RECIPE_TYPES.register("furnace_recipe_type",()->new RecipeType<RKFurnaceRecipe>() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    });
}
