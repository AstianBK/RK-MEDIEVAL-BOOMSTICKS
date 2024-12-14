package com.TBK.medieval_boomsticks.client.gui;

import com.TBK.medieval_boomsticks.common.registers.MBMenuType;
import com.TBK.medieval_boomsticks.common.registers.MBRecipeSerializer;
import com.TBK.medieval_boomsticks.common.registers.MBTags;
import com.TBK.medieval_boomsticks.server.data.recipe.RKFurnaceRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class RKFurnaceContainerMenu extends RecipeBookMenu<Container> {
    private final Container container;
    private final ContainerData data;
    protected final Level level;
    protected final RecipeType<RKFurnaceRecipe> recipeType;
    public RKFurnaceContainerMenu(int p_38963_, Inventory p_38964_, FriendlyByteBuf buf) {
        this(p_38963_,p_38964_,new SimpleContainer(8),new SimpleContainerData(4));
    }
    public RKFurnaceContainerMenu(int p_38852_, Inventory p_38970_, Container p_38971_, ContainerData p_38972_) {
        super(MBMenuType.FURNACE_MENU.get(), p_38852_);
        this.recipeType=MBRecipeSerializer.FURNACE_RECIPE_TYPE.get();
        checkContainerSize(p_38971_, 8);
        checkContainerDataCount(p_38972_, 4);
        this.container = p_38971_;
        this.data = p_38972_;
        this.level = p_38970_.player.level();
        this.addSlot(new Slot(p_38971_, 0, 8, 9));
        this.addSlot(new Slot(p_38971_, 1, 8, 31));
        this.addSlot(new Slot(p_38971_, 2, 8, 54));

        this.addSlot(new FuelSlot(this, p_38971_, 3, 89, 52));

        this.addSlot(new Slot(p_38971_, 4, 152, 9));
        this.addSlot(new Slot(p_38971_, 5, 152, 31));
        this.addSlot(new Slot(p_38971_, 6, 152, 53));

        this.addSlot(new FurnaceResultSlot(p_38970_.player, p_38971_, 7, 88, 13));


        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_38970_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_38970_, k, 8 + k * 18, 142));
        }

        this.addDataSlots(p_38972_);
    }




    @Override
    public void fillCraftSlotsStackedContents(StackedContents p_38976_) {
        if (this.container instanceof StackedContentsCompatible) {
            ((StackedContentsCompatible)this.container).fillStackedContents(p_38976_);
        }

    }

    public boolean isValidSlotIndex(int p_207776_) {
        return p_207776_ == -1 || p_207776_ == -999 || p_207776_ < this.slots.size();
    }

    public void clearCraftingContent() {
        this.getSlot(0).set(ItemStack.EMPTY);
        this.getSlot(1).set(ItemStack.EMPTY);
        this.getSlot(2).set(ItemStack.EMPTY);

        this.getSlot(7).set(ItemStack.EMPTY);
    }

    public boolean recipeMatches(Recipe<? super Container> p_38980_) {
        return p_38980_.matches(this.container, this.level);
    }


    @Override
    public int getResultSlotIndex() {
        return 7;
    }

    @Override
    public int getGridWidth() {
        return 1;
    }

    @Override
    public int getGridHeight() {
        return 1;
    }

    @Override
    public int getSize() {
        return 8;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return null;
    }

    @Override
    public boolean shouldMoveToInventory(int p_150635_) {
        return p_150635_ != 3;
    }


    protected boolean canSmelt(ItemStack p_38978_) {
        return this.level.getRecipeManager().getRecipeFor(MBRecipeSerializer.FURNACE_RECIPE_TYPE.get(), new SimpleContainer(p_38978_), this.level).isPresent();
    }

    protected boolean isFuel(ItemStack p_38989_) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(p_38989_, MBRecipeSerializer.FURNACE_RECIPE_TYPE.get()) > 0;
    }

    public int getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    public int getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }
    @Override
    public ItemStack quickMoveStack(Player p_38986_, int p_38987_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_38987_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_38987_ == 7) {
                if (!this.moveItemStackTo(itemstack1, 8, 44, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_38987_ != 1 && p_38987_ != 0 && p_38987_ != 2 && p_38987_ != 3 && p_38987_ != 5 && p_38987_ != 4 && p_38987_ != 6) {
                if (this.canSmelt(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 3, 4, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isTool(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 4, 7, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_38987_ >= 8 && p_38987_ < 35) {
                if (!this.moveItemStackTo(itemstack1, 35, 44, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_38987_ >= 34 && p_38987_ < 44 && !this.moveItemStackTo(itemstack1, 8, 35, false)) {
                return ItemStack.EMPTY;
            }
        } else if (!this.moveItemStackTo(itemstack1, 8, 44, false)) {
            return ItemStack.EMPTY;
        }

        if (itemstack1.isEmpty()) {
            slot.setByPlayer(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }

        if (itemstack1.getCount() == itemstack.getCount()) {
            return ItemStack.EMPTY;
        }

        slot.onTake(p_38986_, itemstack1);
        }
        return itemstack;
    }

    private boolean isTool(ItemStack itemstack1) {
        return itemstack1.is(MBTags.IS_TOOL_FOR_FURNACE);
    }


    @Override
    public boolean stillValid(Player p_38974_) {
        return this.container.stillValid(p_38974_);
    }
}
