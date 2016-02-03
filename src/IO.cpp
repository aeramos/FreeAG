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


/*  The IO namespace contains functions for input and output. All input and
 *  output for the program must go through these functions
 */

#include "inc/IO.hpp"
#include <cstring>    // For std::strlen

namespace IO {
    void printCenter(WINDOW *winName, char message[]) {
        mvprintw(getmaxy(winName) / 2, (getmaxx(winName) - std::strlen(message)) / 2, "%s", message);
    }
}
