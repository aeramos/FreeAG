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

#ifndef CHARACTER_HPP // for inclusion guard
#define CHARACTER_HPP

#include <string>

class character {
    public:
        character(const std::string& inputName,
                       const unsigned int& inputLevel,
                       const unsigned int& inputXP);

        void setName(const std::string& inputName);
        std::string getName();

        void setLevel(const unsigned int& inputLevel);
        void addLevel(const unsigned int& inputLevel);
        unsigned int getLevel();

        void setXP(const unsigned int& inputXP);
        void addXP(const unsigned int& inputXP);
        unsigned int getXP();

        void setHealth(const unsigned int& inputHealth);
        void addHealth(const unsigned int& inputHealth);
        void subtractHealth(const unsigned int& inputHealth);
        unsigned int getHealth();

        unsigned int getMaxHealth();

        unsigned int getMaxXP();
    private:
        std::string name;
        unsigned int level;
        unsigned int health;
        unsigned int maxHealth;
        unsigned int xp;
        unsigned int maxXP;

        void setMaxHealth();
        void setMaxXP();
        void changeLevel();

};
#endif // inclusion guard