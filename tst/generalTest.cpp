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


/*  This program is made to test the general namespace's functons
 */

#include <iostream>
#include <climits>
#include "../src/inc/general.hpp"

void overflowAddTest();
void overflowSubtractTest();

int main() {
    bool hasRunBefore = false;
    unsigned short int selection;
    std::cout << "Tests for general namespace" << '\n' << std::endl;
    while (true) {
        if (hasRunBefore) {
            std::cout << "\n\n";  // user friendly spacing
        } else {
            hasRunBefore = true;
        }
        std::cout << "Select a function to test" << '\n';
        std::cout << "(0) - End program" << '\n';
        std::cout << "(1) - overflowAdd" << '\n';
        std::cout << "(2) - overflowSubtract" << '\n';
        std::cout << "Selection: ";
        std::cin >> selection;
        if (std::cin.fail() ||
            !(selection >= 0) || !(selection <= 2)) {
            std::cout << "Invalid input" << std::endl;
            return 1;
        }
        std::cin.clear();
        std::cin.ignore();
        switch (selection) {
            case 0:
                std::cout << "Ending program" << std::endl;
                return 0;
                break;
            case 1:
                std::cout << "Testing overflowAdd" << '\n' << std::endl;
                overflowAddTest();
                break;
            case 2:
                std::cout << "Testing overflowSubtract" << '\n' << std::endl;
                overflowSubtractTest();
                break;
        }
    }
}

void overflowAddTest() {
    std::cout << "signed char num = 100" << '\n';
    std::cout << "signed char modifier = 100" << '\n';
    std::cout << "minNum and maxNum = the min and max numbers "
              << "for signed chars" << std::endl;
    std::cout << "Result (should be 127 (the operation will overflow, "
              << "so make it equal to maxNum)): "
              << general::overflowAdd(100, 200,
                 (signed long int)std::numeric_limits<signed char>::min(),
                 (signed long int)std::numeric_limits<signed char>::max())
              << std::endl;
    std::cout << "Press enter to continue with the tests" << std::endl;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cout << "signed char num = 50" << '\n';
    std::cout << "signed char modifier = 75" << '\n';
    std::cout << "signed char minNum = min for signed chars" << '\n';
    std::cout << "maxNum = 100" << '\n';
    std::cout << "Result (should be 100 (goes over maxNum, "
              << "so make it equal to maxNum)): "
              << general::overflowAdd(50, 75,
                 (signed long int)std::numeric_limits<signed char>::min(),
                 (signed long int)100)
              << std::endl;
    std::cout << "Press enter to continue with the tests" << std::endl;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cout << "signed char num = -100" << '\n';
    std::cout << "signed char modifier = -100" << '\n';
    std::cout << "signed char minNum = min for signed chars" << '\n';
    std::cout << "signed char maxNum = max for signed chars" << '\n';
    std::cout << "Result (underflows) (should be -128): "
              << general::overflowAdd(-100, -100,
                 (signed long int)std::numeric_limits<signed char>::min(),
                 (signed long int)std::numeric_limits<signed char>::max())
              << std::endl;
    std::cout << "Press enter to continue with the tests" << std::endl;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cout << "signed char num = 50" << '\n';
    std::cout << "signed char modifier = -100" << '\n';
    std::cout << "signed char minNum = 0" << '\n';
    std::cout << "signed char maxNum = max for signed chars" << '\n';
    std::cout << "Result (goes under minNum) (should be 0): " << std::flush;
    std::cout << general::overflowAdd(50, -100, 0,
                 (signed long int)std::numeric_limits<signed char>::max())
              << std::endl;
    std::cout << '\n' << "Press enter to select another function to test"
              << std::endl;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
}

void overflowSubtractTest() {
    std::cout << "signed char num = -100" << '\n';
    std::cout << "signed char modifier = 100" << '\n'
    std::cout << "signed char minNum = min for signed chars" << '\n';
    std::cout << "signed char maxNum = max for signed chars" << std::endl;
    std::cout << "Result (should be -128 (underflows): "
              << general::overflowSubtract(-100, 100,
                 (signed long int)std::numeric_limits<signed char>::min(),
                 (signed long int)std::numeric_limits<signed char>::max()) 
              << std::endl;
    std::cout << "Press enter to continue with the tests" << std::endl;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cout << "signed char num = 100" << '\n';
    std::cout << "signed char modifier = -100" << '\n';
    std::cout << "signed char minNum = min for signed chars" << '\n';
    std::cout << "signed char maxNum = max for signed chars" << std::endl;
    std::cout << "Result (should be 127 (overflows): "
              << general::overflowSubtract(100, -100,
                 (signed long int)std::numeric_limits<signed char>::min(),
                 (signed long int)std::numeric_limits<signed char>::max())
              << std::endl;
    std::cout << "Press enter to continue with the tests" << '\n';
    std::cin.ignore(std::numeric_limits<std::steamsize>::max(), '\n');

    std::cout << "signed char num = 100" << '\n';
    std::cout << "signed char modifier = 50" << '\n';
    std::cout << "signed char minNum = 75" << '\n';
    std::cout << "signed char maxNum = 100" << std::endl;
    std::cout << "Result (should be 75): "
              << general::overflowSubtract((signed long int)100, 50, 75, 100)
              << std::endl;
    std::cout << "Press enter to continue with the tests" << std::endl;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cout << "signed char num = 0" << '\n';
    std::cout << "signed char modifer = -100" << '\n';
    std::cout << "signed char minNum = -50" << '\n';
    std::cout << "signed char maxNum = 75" << std::endl;
    std::cout << "Result (should be 75): "
              << general::overflowSubtract((signed long int)0, -100, -50, 75)
              << std::endl;
    std::cout << '\n' << "Press enter to select another function to test"
              << std::endl;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
}

