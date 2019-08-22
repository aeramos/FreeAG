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

public class Store {
    private String name;
    private ArrayList<ItemStack> itemStacks;

    public Store(String name, ItemStack[] itemStacks) {
        this.name = name;
        this.itemStacks = new ArrayList<ItemStack>(Arrays.asList(itemStacks));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemStack[] getItemStacks() {
        return itemStacks.toArray(new ItemStack[0]);
    }

    public void addItemStack(ItemStack itemStack) {
        itemStacks.add(itemStack);
    }

    public void removeItemStack(int i) {
        itemStacks.remove(i);
    }

    public int buyItem(int i, Character character, int amount) {
        if (itemStacks.get(i).getAmount() >= amount) {
            if (amount > 0) {
                ItemStack characterMoney = character.getItem(ItemStack.ItemType.COIN);
                if (characterMoney != null && characterMoney.getAmount() >= itemStacks.get(i).getType().getValue() * amount) {
                    if (character.addItem(itemStacks.get(i).getItems(amount))) {
                        character.getItem(ItemStack.ItemType.COIN).changeAmount(itemStacks.get(i).getType().getValue() * -amount);
                        return 0;
                    } else {
                        itemStacks.get(i).changeAmount(amount);
                        return 4; // out of inventory
                    }
                }
                return 3; // out of money
            }
            return 2;
        }
        return 1; // out of stock
    }
}
