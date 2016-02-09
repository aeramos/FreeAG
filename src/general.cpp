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

namespace general {
    // Addition functions to stop overflow
    signed long int overflowAdd(const signed long int& num,
                                const signed long int& modifier,
                                const signed long int& minNum,
                                const signed long int& maxNum) {

        // If they gave a negative modifier, then it is like
        // 3 + (-3) = 0. It is just like 3 - 3 = 0, so send it to the
        // subtraction function
        if (modifier < 0) {
            return overflowSubtact(num, modifier, minNum, maxNum);

        // Check for integer overflows
        } else if (num + modifier < num
            // Check if it goes over the max number
                || num + modifier > maxNum) {
            // It overflowed, so make it the max possible number that doesn't
            // overflow
            return maxNum;
        } else {
            // It won't overflow, so it is safe to perform the operation
            return (num + modifier);
        }
    }
    unsigned long int overflowAdd(const unsigned long int& num,
                                  const unsigned long int& modifier,
                                  const unsigned long int& minNum,
                                  const unsigned long int& maxNum) {

        // Check for integer overflows
        } if (num + modifier < num
            // Check if it goes over the max number
           || num + modifier > maxNum) {
            // It overflowed, so make it the max possible number that doesn't
            // overflow
            return maxNum;
        } else {
            // It won't overflow, so it is safe to perform the operation
            return (num + modifier);
        }
    }

    // Subtraction
    signed long int overflowSubtract(const signed long int& num,
                                     const signed long int& modifier,
                                     const signed long int& minNum,
                                     const signed long int& maxNum) {

        // If they gave a negative modifier, then it is like
        // 3 - (-3) = 6. It is the same as 3 + 3 = 6, so send it to the
        // addition function
        if (modifier > 0) {
            return overflowAdd(num, modifier, minNum, maxNum);

        // Check for integer overflows
        } else if (num - modifier > num
            // Check if it goes under the min number
                || num - modifier < minNum) {
            // It overflowed, so make it the min possible number that doesn't
            // overflow
            return minNum;
        } else {
            // It won't overflow, so it is safe to perform the operation
            return (num + modifier);
        }
    }
    unsigned long int overflowSubtract(const unsigned long int& num,
                                       const unsigned long int& modifier,
                                       const unsigned long int& minNum,
                                       const unsigned long int& maxNum) {
        if (num - modifier > num
            // Check if it goes under the min number
         || num - modifier < minNum) {
            // It overflowed, so make it the min possible number that doesn't
            // overflow
            return minNum;
        } else {
            // It won't overflow, so it is safe to perform the operation
            return (num + modifier);
        }
    }

    // Multiplication
    signed long int overflowMultiply(const signed long int& num,
                                     const signed long int& modifier,
                                     const signed long int& minNum,
                                     const signed long int& maxNum) {

        // Check for integer overflows
        if (num * modifier < num || num * modifier < modifier
                                 || num * modifier > maxNum) {

            // If the end result is going to be greater than num and modifier
            if ((num > 0 && modifier > 0) || (num < 0 && modifier < 0)) {

                // It overflowed, so make it the max possible number that
                // doesn't overflow
                return maxNum;
            } else {
                // It had an overflow because one number was negative and it
                // went under the bound, so make it the min possible number
                // that doesn't do this
                return minNum;
            }

        // If num or modifier <= 0, then the answer can be less than minNum
        } else if (num * modifier < minNum) {
            return minNum;
        } else {
            // It won't overflow, so give the final answer
            return (num * modifier);
        }
    }
    unsigned long int overflowMultiply(const unsigned long int& num,
                                       const unsigned long int& modifier,
                                       const unsigned long int& minNum,
                                       const unsigned long int& maxNum) {

        // Check for integer overflows
        if (num * modifier < num || num * modifier < modifier
                                 || num * modifier > maxNum) {

            // It overflowed, so make it the max possible number that
            // doesn't overflow
            return maxNum;

        // If num or modifier = 0, then the answer can be less than minNum
        } else if (num * modifier < minNum) {
            return minNum;
        } else {
            // It won't overflow, so give the final answer
            return (num * modifier);
        }
    }

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
