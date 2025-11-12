package com.pluralsight;

import java.util.List;

/**
 * Interactive drink prompts.
 */
public class DrinksInterface {

    public void processAddDrinks() {
        Drinks model = new Drinks();
        List<String> flavors = model.getDrinkFlavorList();
        Console.printlnColor("==========================================", Console.BLUE);
        for (int i = 0; i < flavors.size(); i++) Console.println("  " + (i + 1) + " - " + flavors.get(i));
        Console.println("  0 - Cancel");

        int choice = Console.promptInt("Choose flavor: ");
        if (choice == 0) return;
        if (choice < 1 || choice > flavors.size()) {
            Console.printlnColor("Invalid choice.", Console.RED);
            return;
        }
        String flavor = flavors.get(choice - 1);

        Console.printlnColor("""
                ==========================================
                Select size:
                1 - Small
                2 - Medium
                3 - Large
                """, Console.CYAN);
        int sizeChoice = Console.promptInt("Choose: ");
        String size = switch (sizeChoice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> {
                Console.printlnColor("Invalid size. Defaulting to Small.", Console.YELLOW);
                yield "Small";
            }
        };

        Drinks d = new Drinks(flavor, size);
        UserInterface.orderList.addItems(d);
        Console.printlnColor(flavor + " (" + size + ") added to order.", Console.GREEN);
    }
}
