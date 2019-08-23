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

public class ItemStack {
    private Item item;
    private int amount;

    public enum Item {
        COIN("Coin", ItemType.MONEY, 1), APPLE("Apple", ItemType.FOOD, 5), COPPER_ORE("Copper ore", ItemType.ORE, 10), TIN_ORE("Tin ore", ItemType.ORE, 10), BRONZE("Bronze ingot", ItemType.METAL, 100);

        private final String name;
        private final ItemType type;
        private final int value;

        Item(String name, ItemType type, int value) {
            this.name = name;
            this.type = type;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public ItemType getType() {
            return type;
        }
    }

    public enum ItemType {
        MONEY, FOOD, ORE, METAL
    }

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public static ItemStack[] combine(ItemStack[] stack1, ItemStack... stack2) {
        ArrayList<ItemStack> result = new ArrayList<ItemStack>(Arrays.asList(stack1));
        for (int i = 0; i < stack2.length; i++) {
            Item type = stack2[i].getItem();

            boolean added = false;
            for (int j = 0; j < result.size(); j++) {
                if (type == result.get(i).getItem()) {
                    result.get(i).changeAmount(stack2[i].getAmount());
                    added = true;
                    break;
                }
            }
            if (!added) {
                result.add(stack2[i]);
            }
        }
        return result.toArray(new ItemStack[0]);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void changeAmount(int amount) {
        this.amount += amount;
    }

    public ItemStack removeItems(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return new ItemStack(this.item, amount);
        } else {
            return null;
        }
    }
}
