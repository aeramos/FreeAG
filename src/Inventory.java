/*
 * This file is part of FreeAG.
 * Copyright (C) 2019 Alejandro Ramos
 *
 * FreeAG is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FreeAG is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with FreeAG.  If not, see <https://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {
    private ArrayList<ItemStack> itemStacks;
    private int inventorySize;

    public Inventory(int inventorySize) {
        this.inventorySize = inventorySize;
        this.itemStacks = new ArrayList<>();
    }

    public Inventory(int inventorySize, ItemStack[] itemStacks) {
        this.inventorySize = inventorySize;
        this.itemStacks = new ArrayList<>(Arrays.asList(itemStacks));
    }

    public ItemStack get(int i) {
        return itemStacks.get(i);
    }

    public ItemStack get(ItemStack.Item item) {
        for (ItemStack itemStack : itemStacks) {
            if (itemStack.getItem() == item) {
                return itemStack;
            }
        }
        return null;
    }

    public ItemStack[] get(ItemStack.ItemType type) {
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        for (ItemStack itemStack : itemStacks) {
            if (itemStack.getItem().getType() == type) {
                items.add(itemStack);
            }
        }
        return items.toArray(new ItemStack[0]);
    }

    public boolean add(ItemStack itemStack) {
        for (ItemStack stack : itemStacks) {
            if (stack.getItem() == itemStack.getItem()) {
                stack.changeAmount(itemStack.getAmount());
                return true;
            }
        }
        if (itemStacks.size() < inventorySize || inventorySize == 0) {
            itemStacks.add(itemStack);
            return true;
        } else {
            return false;
        }
    }

    public ItemStack remove(int i) {
        return itemStacks.remove(i);
    }

    public int size() {
        return itemStacks.size();
    }
}
