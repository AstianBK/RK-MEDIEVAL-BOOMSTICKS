package com.TBK.medieval_boomsticks.common;

import com.TBK.medieval_boomsticks.RKMedievalBoomStick;
import com.TBK.medieval_boomsticks.client.gui.RKFurnaceContainerMenu;
import com.TBK.medieval_boomsticks.common.registers.MBBlockEntity;
import com.TBK.medieval_boomsticks.common.registers.MBRecipeSerializer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class RKFurnaceEntity extends AbstractFurnaceBlockEntity {
    public RKFurnaceEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(MBBlockEntity.RK_FURNACE_ENTITY.get(), p_154992_, p_154993_, MBRecipeSerializer.FURNACE_RECIPE_TYPE.get());
        this.items= NonNullList.withSize(8, ItemStack.EMPTY);
    }
    public static void serverTicks(Level p_155014_, BlockPos p_155015_, BlockState p_155016_, RKFurnaceEntity p_155017_) {
        boolean flag = p_155017_.isLit();
        boolean flag1 = false;
        if (p_155017_.isLit()) {
            --p_155017_.litTime;
        }

        ItemStack itemstack = p_155017_.items.get(3);
        boolean flag2 = p_155017_.fullSlotAddition(p_155017_.items);
        boolean flag3 = !itemstack.isEmpty();
        if (p_155017_.isLit() || flag3 && flag2) {
            Recipe<?> recipe;
            if (flag2) {
                recipe = p_155017_.quickCheck.getRecipeFor(p_155017_, p_155014_).orElse(null);
            } else {
                recipe = null;
            }

            int i = p_155017_.getMaxStackSize();
            if (!p_155017_.isLit() && p_155017_.canBurn(p_155014_.registryAccess(), recipe, p_155017_.items, i)) {
                p_155017_.litTime = p_155017_.getBurnDuration(itemstack);
                p_155017_.litDuration = p_155017_.litTime;
                if (p_155017_.isLit()) {
                    flag1 = true;
                    if (itemstack.hasCraftingRemainingItem())
                        p_155017_.items.set(1, itemstack.getCraftingRemainingItem());
                    else
                    if (flag3) {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            p_155017_.items.set(1, itemstack.getCraftingRemainingItem());
                        }
                    }
                }
            }

            if (p_155017_.isLit() && p_155017_.canBurn(p_155014_.registryAccess(), recipe, p_155017_.items, i)) {
                ++p_155017_.cookingProgress;
                if (p_155017_.cookingProgress == p_155017_.cookingTotalTime) {
                    p_155017_.cookingProgress = 0;
                    p_155017_.cookingTotalTime = getTotalCookTime(p_155014_, p_155017_);
                    if (p_155017_.burn(p_155014_.registryAccess(), recipe, p_155017_.items, i)) {
                        p_155017_.setRecipeUsed(recipe);
                    }

                    flag1 = true;
                }
            } else {
                p_155017_.cookingProgress = 0;
            }
        } else if (!p_155017_.isLit() && p_155017_.cookingProgress > 0) {
            p_155017_.cookingProgress = Mth.clamp(p_155017_.cookingProgress - 2, 0, p_155017_.cookingTotalTime);
        }

        if (flag != p_155017_.isLit()) {
            flag1 = true;
            p_155016_ = p_155016_.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(p_155017_.isLit()));
            p_155014_.setBlock(p_155015_, p_155016_, 3);
        }

        if (flag1) {
            setChanged(p_155014_, p_155015_, p_155016_);
        }

    }

    public boolean stillValid(Player p_58340_) {
        return Container.stillValidBlockEntity(this, p_58340_);
    }

    public boolean canPlaceItem(int p_58389_, ItemStack p_58390_) {
        if (p_58389_ == 7) {
            return false;
        } else if (p_58389_ != 0 && p_58389_ !=1 && p_58389_!=2 && p_58389_!=4 && p_58389_!=5 && p_58389_!=6) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(p_58389_);
            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58390_,MBRecipeSerializer.FURNACE_RECIPE_TYPE.get()) > 0 || p_58390_.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
    }

    public boolean fullSlotAddition(NonNullList<ItemStack> list){
        return !list.get(0).isEmpty() && !list.get(1).isEmpty() && !list.get(2).isEmpty();
    }

    public boolean fullSlotTool(NonNullList<ItemStack> list){
        return !list.get(4).isEmpty() && !list.get(5).isEmpty() && !list.get(6).isEmpty();
    }

    public boolean fullSlot(NonNullList<ItemStack> list){
        return fullSlotAddition(list) && fullSlotTool(list);
    }
    public boolean canBurn(RegistryAccess p_266924_, @Nullable Recipe<?> p_155006_, NonNullList<ItemStack> p_155007_, int p_155008_) {
        if (fullSlot(p_155007_) && p_155006_ != null) {
            ItemStack itemstack = ((Recipe<WorldlyContainer>) p_155006_).assemble(this, p_266924_);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = p_155007_.get(7);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    public boolean burn(RegistryAccess p_266740_, @Nullable Recipe<?> p_266780_, NonNullList<ItemStack> p_267073_, int p_267157_) {
        if (p_266780_ != null && this.canBurn(p_266740_, p_266780_, p_267073_, p_267157_)) {
            ItemStack addition1 = p_267073_.get(0);
            ItemStack addition2 = p_267073_.get(1);
            ItemStack addition3 = p_267073_.get(2);

            ItemStack tool1 = p_267073_.get(4);
            ItemStack tool2 = p_267073_.get(5);
            ItemStack tool3 = p_267073_.get(6);

            ItemStack itemstack1 = ((Recipe<WorldlyContainer>) p_266780_).assemble(this, p_266740_);
            ItemStack itemstack2 = p_267073_.get(7);
            if (itemstack2.isEmpty()) {
                p_267073_.set(7, itemstack1.copy());
            } else if (itemstack2.is(itemstack1.getItem())) {
                itemstack2.grow(itemstack1.getCount());
            }

            tool1.setDamageValue(tool1.getDamageValue()+1);
            tool2.setDamageValue(tool2.getDamageValue()+1);
            tool3.setDamageValue(tool3.getDamageValue()+1);

            addition1.shrink(1);
            addition2.shrink(1);
            addition3.shrink(1);

            return true;
        } else {
            return false;
        }
    }

    protected int getBurnDuration(ItemStack p_58343_) {
        if (p_58343_.isEmpty()) {
            return 0;
        } else {
            Item item = p_58343_.getItem();
            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58343_, MBRecipeSerializer.FURNACE_RECIPE_TYPE.get());
        }
    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int p_58627_, Inventory p_58628_) {
        return new RKFurnaceContainerMenu(p_58627_,p_58628_,this,this.dataAccess);
    }
}
