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


/*  The general namespace contains general functions for variable manipulation
 *  and other functions
 */

#ifndef GENERAL_HPP // for inclusion guard
#define GENERAL_HPP

namespace general {
    // Addition functions to stop overflow
    signed long int overflowAdd(const signed long int& num,
                                const signed long int& modifier,
                                const signed long int& minNum,
                                const signed long int& maxNum);
    unsigned long int overflowAdd(const unsigned long int& num,
                                  const unsigned long int& modifier,
                                  const unsigned long int& minNum,
                                  const unsigned long int& maxNum);

    // Subtraction
    signed long int overflowSubtract(const signed long int& num,
                                     const signed long int& modifier,
                                     const signed long int& minNum,
                                     const signed long int& maxNum);
    unsigned long int overflowSubtract(const unsigned long int& num,
                                       const unsigned long int& modifier,
                                       const unsigned long int& minNum,
                                       const unsigned long int& maxNum);

    // Multiplication
    signed long int overflowMultiply(const signed long int& num,
                                     const signed long int& modifier,
                                     const signed long int& minNum,
                                     const signed long int& maxNum);
    unsigned long int overflowMultiply(const unsigned long int& num,
                                       const unsigned long int& modifier,
                                       const unsigned long int& minNum,
                                       const unsigned long int& maxNum);

    // Division
    signed long int overflowDivide(const signed long int& num,
                                   const signed long int& modifier,
                                   const signed long int& minNum,
                                   const signed long int& maxNum);
    unsigned long int overflowDivide(const unsigned long int& num,
                                     const unsigned long int& modifier,
                                     const unsigned long int& minNum,
                                     const unsigned long int& maxNum);
}
#endif // inclusion guard
