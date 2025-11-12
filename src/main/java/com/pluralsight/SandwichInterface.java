package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

/**
 * Sandwich creation prompts.
 */
public class SandwichInterface {

    public void processAddSandwich() {
        Console.printlnColor("""
            =================================================
                Please select from the following choices:
                1 - Make your own Custom Sandwich
                2 - Choose one of our Signature Sandwiches
                0 - Cancel
            =================================================
            """, Console.CYAN);

        int choice = Console.promptInt("Choose: ");
        switch (choice) {
            case 1 -> processCustomSandwich();
            case 2 -> processSignatureSandwich();
            case 0 -> {
                Console.printlnColor("Cancelling sandwich selection.", Console.YELLOW);
                return;
            }
            default -> Console.printlnColor("Invalid selection.", Console.RED);
        }
    }

    private void processCustomSandwich() {
        List<String> breadOptions = new Sandwich().getBreadOptions();
        Console.printlnColor("==========================================", Console.BLUE);
        for (int i = 0; i < breadOptions.size(); i++) {
            Console.println("  " + (i + 1) + " - " + breadOptions.get(i));
        }
        Console.println("  0 - Cancel");

        int breadChoice = Console.promptInt("Choose bread: ");
        if (breadChoice == 0) return;
        if (breadChoice < 1 || breadChoice > breadOptions.size()) {
            Console.printlnColor("Invalid bread choice.", Console.RED);
            return;
        }
        String bread = breadOptions.get(breadChoice - 1);

        String size;
        while (true) {
            String s = Console.promptLine("""
                    Choose Sandwich Size:
                    4 - 4" ($5.50)
                    8 - 8" ($7.00)
                    12 - 12" ($8.50)
                    Enter 4, 8, or 12:
                    """);
            if (s.equals("4") || s.equals("8") || s.equals("12")) { size = s; break; }
            Console.printlnColor("Invalid size. Try again.", Console.RED);
        }

        String toasted = Console.promptLine("Would you like the sandwich toasted? (Yes/No): ");

        List<Toppings> toppingsList = new ArrayList<>();
        new ToppingsInterface().processAddToppings(toppingsList, size);

        Sandwich s = new Sandwich();
        s.setName("Custom Sandwich");
        s.setQuantity(1);
        // we need a constructor that sets these values easily; use existing one:
        Sandwich sandwich = new Sandwich(bread, size, toppingsList, toasted.equalsIgnoreCase("y") || toasted.equalsIgnoreCase("yes") ? "Yes" : "No");
        // set name explicitly:
        sandwich.setName("Custom Sandwich");
        Orders orders = UserInterface.orderList;
        orders.addItems(sandwich);
        Console.printlnColor("Sandwich added!", Console.GREEN);
    }

    private void processSignatureSandwich() {
        Console.printlnColor("""
            =================================================
            Signature sandwiches:
              1 - BLT
              2 - Philly Cheese Steak
              0 - Cancel
            =================================================
            """, Console.CYAN);

        int choice = Console.promptInt("Choose: ");
        switch (choice) {
            case 1 -> {
                Sandwich blt = SignatureSandwiches.createBLT();
                UserInterface.orderList.addItems(blt);
                Console.printlnColor("BLT added to your order.", Console.GREEN);
            }
            case 2 -> {
                Sandwich philly = SignatureSandwiches.createPhillyCheeseSteak();
                UserInterface.orderList.addItems(philly);
                Console.printlnColor("Philly Cheese Steak added to your order.", Console.GREEN);
            }
            case 0 -> Console.printlnColor("Cancelled.", Console.YELLOW);
            default -> Console.printlnColor("Invalid selection.", Console.RED);
        }
    }
}
