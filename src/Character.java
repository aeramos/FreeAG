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

public class Character {
    private String name;
    private ArrayList<ItemStack> inventory;
    private int inventorySize = 32;
    private int level;
    private int xp;
    private int maxXP;
    private int health;
    private int maxHealth;

    public Character(String name, int level, int xp, ItemStack[] inventory) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.inventory = new ArrayList<ItemStack>(Arrays.asList(inventory));
        refreshLevel();
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void changeXP(int change) {
        xp += change;
        refreshLevel();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ItemStack getItem(int i) {
        return inventory.get(i);
    }

    public ItemStack getItem(ItemStack.ItemType type) {
        for (ItemStack itemStack : inventory) {
            if (itemStack.getType() == type) {
                return itemStack;
            }
        }
        return null;
    }

    public boolean addItem(ItemStack itemStack) {
        for (ItemStack stack : inventory) {
            if (stack.getType() == itemStack.getType()) {
                stack.changeAmount(itemStack.getAmount());
                return true;
            }
        }
        if (inventory.size() < inventorySize) {
            inventory.add(itemStack);
            return true;
        } else {
            return false;
        }
    }

    public ItemStack removeItem(int i) {
        return inventory.remove(i);
    }

    private int refreshLevel() {
        maxHealth = level * 100;
        maxXP = level * 10;
        if (xp >= maxXP) {
            xp -= maxXP;
            level++;
            refreshLevel();
        }
        return level;
    }
}
