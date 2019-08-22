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

public class ItemStack {
    private ItemType type;
    private String name;
    private int amount;

    public enum ItemType {
        COIN(1), APPLE(10);

        private final int value;

        ItemType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public ItemStack(ItemType type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void changeAmount(int amount) {
        this.amount += amount;
    }

    public ItemStack getItems(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return new ItemStack(this.type, this.name, amount);
        } else {
            return null;
        }
    }
}
