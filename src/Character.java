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

public class Character {
    private String name;
    private int level;
    private int xp;
    private int maxXP;
    private int health;
    private int maxHealth;

    public Character(String name, int level, int xp) {
        this.name = name;
        this.level = level;
        this.xp = xp;
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

    private void refreshLevel() {
        if (xp >= maxXP) {
            xp -= maxXP;
            level++;
            refreshLevel();
        }
        maxHealth = level * 100;
        maxXP = level * 10;
    }
}
