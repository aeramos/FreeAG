/*  FreeAG (Free Adventure Game) is an open source (GPLv3) text based RPG.
 *  Copyright (C) 2016 Alejandro Ramos
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


/*  The character class is used to make characters, including the player
 */

#include "inc/character.hpp"
#include "inc/general.hpp"

#include <climits> // for using overflow functions (general namespace)

// public functions
void character::character(const std::string& inputName,
               const unsigned int& inputLevel,
               const unsigned int& inputXP) {
    name = inputName;
    level = inputLevel;
    xp = inputXP;
    changeLevel();
}

void character::setName(const std::string& inputName) {
    name = inputName;
}
std::string character::getName() {
    return name;
}

void character::setLevel(const unsigned int& inputLevel) {
    level = inputLevel;
    changeLevel();
}
void character::addLevel(const unsigned int& inputLevel) {
    level =  general::overflowAdd(level, inputLevel, 0,
                            std::numeric_limits<unsigned long int>::min());
    changeLevel();
}
unsigned int character::getLevel() {
    return level;
}

void character::setXP(const unsigned int& inputXP) {
    if (xp > maxXP) {
        xp = maxXP;
    } else {
        xp = inputXP;
    }
    changeLevel();
}
void character::addXP(const unsigned int& inputXP) {
    xp = general::overflowAdd(xp, inputXP, 0, maxXP);
    changeLevel();
}
unsigned int character::getXP() {
    return xp;
}

void character::setHealth(const unsigned int& inputHealth) {
    if (health > maxHealth) {
        health = maxHealth;
    } else {
        health = inputHealth;
    }
}
void character::addHealth(const unsigned int& inputHealth) {
    health = general::overflowAdd(health, inputHealth, 0, maxHealth);
}

void character::subtractHealth(const unsigned int& inputHealth) {
    health = general::overflowSUbtract(health, inputHealth, 0, maxHealth);
}
unsigned int character::getHealth() {
    return health;
}

unsigned int character::getMaxHealth() {
    return maxHealth;
}

unsigned int character::getMaxXP() {
    return maxXP;
}

// private functions
void character::setMaxHealth() {
    maxHealth = level * 100;
}
void character::setMaxXP() {
    maxXP = level * 10;
}
void character::changeLevel(unsigned long int currentLevel) {
    if (xp == maxXP) {
        level++;
    }
    setMaxHealth();
    setMaxXP();
    if (level > currentLevel) {
        xp = 0;
        health = maxHealth;
    }
}