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

public class Store {
    private String name;
    private Inventory inventory;

    public Store(String name, ItemStack[] itemStacks) {
        this.name = name;
        this.inventory = new Inventory(0);
        for (ItemStack itemStack : itemStacks) {
            inventory.add(itemStack);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(ItemStack itemStack) {
        inventory.add(itemStack);
    }

    public ItemStack get(int i) {
        return inventory.get(i);
    }

    public ItemStack remove(int i) {
        return inventory.remove(i);
    }

    public int buyItem(int i, Player player, int amount) {
        if (inventory.get(i).getAmount() >= amount) {
            if (amount > 0) {
                ItemStack characterMoney = player.getInventory().get(ItemStack.Item.COIN);
                if (characterMoney != null && characterMoney.getAmount() >= inventory.get(i).getItem().getValue() * amount) {
                    if (player.getInventory().add(inventory.get(i).removeItems(amount))) {
                        player.getInventory().get(ItemStack.Item.COIN).changeAmount(inventory.get(i).getItem().getValue() * -amount);
                        return 0;
                    } else {
                        inventory.get(i).changeAmount(amount);
                        return 4; // out of inventory
                    }
                }
                return 3; // out of money
            }
            return 2;
        }
        return 1; // out of stock
    }

    public int size() {
        return inventory.size();
    }
}
