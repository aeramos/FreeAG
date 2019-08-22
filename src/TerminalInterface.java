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

import java.util.Scanner;

public class TerminalInterface {
    public static void store(Store store, Character character) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean badInput;
        boolean shopping = true;
        ItemStack[] stock = store.getItemStacks();

        System.out.println("Hello " + character.getName() + ", welcome to " + store.getName());
        while (shopping) {
            int selection = -1;
            badInput = true;
            while (badInput) {
                System.out.println("We are currently selling: ");
                for (int i = 0; i < stock.length; i++) {
                    System.out.println("(" + (i + 1) + ") " + stock[i].getAmount() + " " + stock[i].getName() + " - " + stock[i].getType().getValue() + " coins each");
                }

                System.out.println("What would you like to buy?");
                input = scanner.nextLine();
                try {
                    selection = Integer.parseInt(input) - 1;
                } catch (NumberFormatException ignored) {
                }

                if (selection >= 0 && selection < stock.length) {
                    badInput = false;
                } else {
                    System.out.println("Bad input.\n");
                }
            }

            badInput = true;
            int amount = -1;
            while (badInput) {
                System.out.println("How many " + stock[selection].getName() + " would you like? We have " + stock[selection].getAmount() + " in stock.");
                input = scanner.nextLine();
                try {
                    amount = Integer.parseInt(input);
                    badInput = false;
                } catch (NumberFormatException e) {
                    System.out.println("Bad input.\n");
                }
            }
            int errorCode = store.buyItem(selection, character, amount);

            switch (errorCode) {
                case 0:
                    System.out.println("You have just purchased " + amount + " " + stock[selection].getName() + "!");
                    break;
                case 1:
                    System.out.println("The store doesn't have that many " + stock[selection].getName() + " in stock!");
                    break;
                case 2:
                    System.out.println("You can't buy 0 " + stock[selection].getName());
                    break;
                case 3:
                    System.out.println("You don't have enough coins to pay for " + amount + " " + stock[selection].getName() + "!");
                    break;
                case 4:
                    System.out.println("You don't have enough inventory space for " + amount + " " + stock[selection].getName() + "!");
                    break;
            }

            badInput = true;
            while (badInput) {
                System.out.println("Would you like to buy something else? (y/n)");
                input = scanner.nextLine();
                if (input.equals("y")) {
                    badInput = false;
                } else if (input.equals("n")) {
                    badInput = false;
                    System.out.println("Goodbye!");
                    shopping = false;
                } else {
                    System.out.println("Bad input.\n");
                }
            }
        }
    }
}
