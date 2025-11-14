package com.pluralsight;
import java.util.List;
/**
 * Interactive toppings prompts.
 */
public class ToppingsInterface {

    //method to add toppings to a custom sandwich which is stored as a list
    public void processAddToppings(List<Toppings> toppingsList, String sandwichSize) {
        Toppings toppingsModel = new Toppings();

        // Meat toppings for a random sandwich
        while (true) {
            Console.printlnColor("==========================================", Console.BLUE);
            Console.println("Choose a meat topping (or 0 to skip):");
            var meatOptions = toppingsModel.getMeatOptions();
            for (int i = 0; i < meatOptions.size(); i++) {
                Console.println("  " + (i + 1) + " - " + meatOptions.get(i));
            }

            int choice = Console.promptInt("Selection made: ");

            //if the choice is 0 (zero) it skips adding meat
            if (choice == 0)
                break;

            if (choice >= 1 && choice <= meatOptions.size()) {
                String selected = meatOptions.get(choice - 1);
                String extra = Console.promptLine("Would you like extra " + selected + "? (Yes/No): ");
                boolean isExtra = extra.equalsIgnoreCase("y") || extra.equalsIgnoreCase("yes");
                toppingsList.add(new Toppings(selected, "Meat", isExtra));
                break;

            } else {
                Console.printlnColor("Invalid selection. Try again.", Console.RED);
            }
        }

        // CHEESE
        while (true) {
            Console.printlnColor("==========================================", Console.BLUE);
            Console.println("Choose a cheese topping (or 0 to skip):");
            var cheeseOptions = toppingsModel.getCheeseOptions();
            for (int i = 0; i < cheeseOptions.size(); i++) {
                Console.println("  " + (i + 1) + " - " + cheeseOptions.get(i));
            }

            int choice = Console.promptInt("Choose: ");
            if (choice == 0) break;
            if (choice >= 1 && choice <= cheeseOptions.size()) {
                String selected = cheeseOptions.get(choice - 1);
                String extra = Console.promptLine("Would you like extra " + selected + "? (Yes/No): ");
                boolean isExtra = extra.equalsIgnoreCase("y") || extra.equalsIgnoreCase("yes");
                toppingsList.add(new Toppings(selected, "Cheese", isExtra));
                break;
            } else {
                Console.printlnColor("Invalid selection. Try again.", Console.RED);
            }
        }

        // REGULAR (up to 4)
        int regularCount = 0;
        while (true) {
            if (regularCount >= 4) {
                Console.printlnColor("Maximum of 4 regular toppings reached.", Console.YELLOW);
                break;
            }
            Console.printlnColor("==========================================", Console.BLUE);
            Console.println("Choose a regular topping (0 done):");
            var regular = toppingsModel.getRegularOptions();
            for (int i = 0; i < regular.size(); i++) {
                Console.println("  " + (i + 1) + " - " + regular.get(i));
            }
            int choice = Console.promptInt("Choose: ");
            if (choice == 0) break;
            if (choice >= 1 && choice <= regular.size()) {
                String selected = regular.get(choice - 1);
                toppingsList.add(new Toppings(selected, "Regular"));
                regularCount++;
                String another = Console.promptLine("Add another regular topping? (Yes/No): ");
                if (!another.equalsIgnoreCase("y") && !another.equalsIgnoreCase("yes")) break;
            } else {
                Console.printlnColor("Invalid selection. Try again.", Console.RED);
            }
        }

        // SAUCES (up to 4)
        int sauceCount = 0;
        while (true) {
            if (sauceCount >= 4) {
                Console.printlnColor("Maximum of 4 sauces reached.", Console.YELLOW);
                break;
            }
            Console.printlnColor("==========================================", Console.BLUE);
            Console.println("Choose a sauce (0 done):");
            var sauce = toppingsModel.getSauceOptions();
            for (int i = 0; i < sauce.size(); i++) {
                Console.println("  " + (i + 1) + " - " + sauce.get(i));
            }
            int choice = Console.promptInt("Choose: ");
            if (choice == 0) break;
            if (choice >= 1 && choice <= sauce.size()) {
                String selected = sauce.get(choice - 1);
                toppingsList.add(new Toppings(selected, "Sauce"));
                sauceCount++;
                String another = Console.promptLine("Add another sauce? (Yes/No): ");
                if (!another.equalsIgnoreCase("y") && !another.equalsIgnoreCase("yes")) break;
            } else {
                Console.printlnColor("Invalid selection. Try again.", Console.RED);
            }
        }

        // Note: topping price calculations will happen in Sandwich.calculatePrice
    }
}
