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
    public static void store(Store store, Player player) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean badInput;
        boolean shopping = true;

        System.out.println("Hello " + player.getName() + ", welcome to " + store.getName());
        while (shopping) {
            int selection = -1;
            badInput = true;
            while (badInput) {
                System.out.println("We are currently selling: ");
                for (int i = 0; i < store.size(); i++) {
                    System.out.println("(" + (i + 1) + ") " + store.get(i).getAmount() + " " + store.get(i).getItem().getName() + " - " + store.get(i).getItem().getValue() + " coins each");
                }

                System.out.println("What would you like to buy?");
                input = scanner.nextLine();
                try {
                    selection = Integer.parseInt(input) - 1;
                } catch (NumberFormatException ignored) {
                }

                if (selection >= 0 && selection < store.size()) {
                    badInput = false;
                } else {
                    System.out.println("Bad input.\n");
                }
            }

            badInput = true;
            int amount = -1;
            while (badInput) {
                System.out.println("How many " + store.get(selection).getItem().getName() + " would you like? We have " + store.get(selection).getAmount() + " in stock.");
                input = scanner.nextLine();
                try {
                    amount = Integer.parseInt(input);
                    badInput = false;
                } catch (NumberFormatException e) {
                    System.out.println("Bad input.\n");
                }
            }
            int errorCode = store.buyItem(selection, player, amount);

            switch (errorCode) {
                case 0:
                    System.out.println("You have just purchased " + amount + " " + store.get(selection).getItem().getName() + "!");
                    break;
                case 1:
                    System.out.println("The store doesn't have that many " + store.get(selection).getItem().getName() + " in stock!");
                    break;
                case 2:
                    System.out.println("You can't buy 0 " + store.get(selection).getItem().getName());
                    break;
                case 3:
                    System.out.println("You don't have enough coins to pay for " + amount + " " + store.get(selection).getItem().getName() + "!");
                    break;
                case 4:
                    System.out.println("You don't have enough inventory space for " + amount + " " + store.get(selection).getItem().getName() + "!");
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
