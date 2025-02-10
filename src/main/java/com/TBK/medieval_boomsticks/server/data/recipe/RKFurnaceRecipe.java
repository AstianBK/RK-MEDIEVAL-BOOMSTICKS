package com.TBK.medieval_boomsticks.server.data.recipe;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.common.registers.MBRecipeSerializer;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.Arrays;

public class RKFurnaceRecipe extends AbstractCookingRecipe {
    protected final RecipeType<?> type;
    protected final ResourceLocation id;
    
    protected final ItemStack result;
    protected final float experience;
    protected final int cookingTime;
    public final Ingredient addition1;
    public final Ingredient addition2;
    protected final Ingredient addition3;
    protected final Ingredient tool1;
    protected final Ingredient tool2;
    protected final Ingredient tool3;
    public RKFurnaceRecipe(ResourceLocation p_249379_,Ingredient addition1,Ingredient addition2, Ingredient addition3,Ingredient tool1,Ingredient tool2,Ingredient tool3, ItemStack p_252185_, float p_252165_, int p_250256_) {
        super(MBRecipeSerializer.FURNACE_RECIPE_TYPE.get(),p_249379_,"Horno",CookingBookCategory.MISC,addition1,p_252185_,p_252165_,p_250256_);
        this.type=MBRecipeSerializer.FURNACE_RECIPE_TYPE.get();
        this.id=p_249379_;
        this.addition1=addition1;
        this.addition2=addition2;
        this.addition3=addition3;
        this.tool1=tool1;
        this.tool2=tool2;
        this.tool3=tool3;
        this.cookingTime=p_250256_;
        this.experience=p_252165_;
        this.result=p_252185_;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        ItemStack addition1=p_44002_.getItem(0);
        ItemStack addition2=p_44002_.getItem(1);
        ItemStack addition3=p_44002_.getItem(2);

        ItemStack tool1=p_44002_.getItem(4);
        ItemStack tool2=p_44002_.getItem(5);
        ItemStack tool3=p_44002_.getItem(6);


        return this.addition1.test(addition1) && this.addition2.test(addition2) && this.addition3.test(addition3) && this.tool1.test(tool1) && this.tool2.test(tool2) && this.tool3.test(tool3);
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.addition1);
        nonnulllist.add(this.addition2);
        nonnulllist.add(this.addition3);
        nonnulllist.add(this.tool1);
        nonnulllist.add(this.tool2);
        nonnulllist.add(this.tool3);
        return nonnulllist;
    }
    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MBRecipeSerializer.NEW_FURNACE_RECIPE.get();
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    public static class Serializer implements RecipeSerializer<RKFurnaceRecipe> {
        public RKFurnaceRecipe fromJson(ResourceLocation p_44562_, JsonObject p_44563_) {
            Ingredient ingredient1 = Ingredient.fromJson(GsonHelper.getAsJsonObject(p_44563_, "ingredient1"));
            Ingredient ingredient2 = p_44563_.has("ingredient2") ? Ingredient.fromJson(GsonHelper.getAsJsonObject(p_44563_, "ingredient2")) : Ingredient.EMPTY;
            Ingredient ingredient3 = p_44563_.has("ingredient3") ? Ingredient.fromJson(GsonHelper.getAsJsonObject(p_44563_,"ingredient3")) : Ingredient.EMPTY;
            Ingredient tool1 = Ingredient.fromJson(GsonHelper.getAsJsonObject(p_44563_,"tool1"));
            Ingredient tool2 = Ingredient.fromJson(GsonHelper.getAsJsonObject(p_44563_,"tool2"));
            Ingredient tool3 = Ingredient.fromJson(GsonHelper.getAsJsonObject(p_44563_,"tool3"));
            ItemStack result = getItemForJson(p_44563_,"result");
            float f = GsonHelper.getAsFloat(p_44563_, "experience", 0.0F);
            int i = GsonHelper.getAsInt(p_44563_, "cooking_time", 200);

            return new RKFurnaceRecipe(p_44562_, ingredient1, ingredient2,ingredient3,tool1,tool2,tool3,result,f,i);
        }

        private ItemStack getItemForJson(JsonObject p_44563_,String name) {
            if (!p_44563_.has(name)) throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
            ItemStack itemstack;
            if (p_44563_.get(name).isJsonObject()) itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(p_44563_, name));
            else {
                String s1 = GsonHelper.getAsString(p_44563_, name);
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                itemstack = new ItemStack(BuiltInRegistries.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
                    return new IllegalStateException("Item: " + s1 + " does not exist");
                }));
            }
            return itemstack;
        }

        public RKFurnaceRecipe fromNetwork(ResourceLocation p_44565_, FriendlyByteBuf p_44566_) {
            Ingredient ingredient1 = Ingredient.fromNetwork(p_44566_);
            Ingredient ingredient2 = Ingredient.fromNetwork(p_44566_);
            Ingredient ingredient3 = Ingredient.fromNetwork(p_44566_);
            int cookingTime = p_44566_.readInt();
            Ingredient tool1 = Ingredient.fromNetwork(p_44566_);
            Ingredient tool2 = Ingredient.fromNetwork(p_44566_);
            Ingredient tool3 = Ingredient.fromNetwork(p_44566_);
            ItemStack result = p_44566_.readItem();
            float exp = p_44566_.readFloat();
            return new RKFurnaceRecipe(p_44565_, ingredient1, ingredient2,ingredient3,tool1,tool2,tool3,result,exp,cookingTime);
        }

        public void toNetwork(FriendlyByteBuf p_44553_, RKFurnaceRecipe p_44554_) {
            p_44554_.addition1.toNetwork(p_44553_);
            p_44554_.addition2.toNetwork(p_44553_);
            p_44554_.addition3.toNetwork(p_44553_);
            p_44553_.writeInt(p_44554_.cookingTime);
            p_44554_.tool1.toNetwork(p_44553_);
            p_44554_.tool2.toNetwork(p_44553_);
            p_44554_.tool3.toNetwork(p_44553_);
            p_44553_.writeItem(p_44554_.result);
            p_44553_.writeFloat(p_44554_.experience);
        }
    }
}
