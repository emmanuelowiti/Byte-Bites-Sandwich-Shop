package com.pluralsight;

import static com.pluralsight.Console.*;

/**
 * Main UI: Home, Order screen, Checkout.
 */
public class UserInterface {

    // Shared order list
    public static final Orders orderList = new Orders();

    public void homeScreen() {
        while (true) {
            printlnColor("""
                 ===============================================================
                  🥪🥪 Byte Bites - where every byte builds a better bite 🥪🥪
                 ===============================================================
                    Please select from the following choices:
                    1 - New Order
                    0 - Exit
                 ===============================================================
                """, BLUE);

            int choice = promptInt("Choose: ");
            switch (choice) {
                case 1 -> orderScreen();
                case 0 -> {
                    printlnColor("Goodbye — thanks for using Byte Bites!", GREEN);
                    return;
                }
                default -> printlnColor("Invalid entry! Try again.", RED);
            }
        }
    }

    public void orderScreen() {
        SandwichInterface sandwichInterface = new SandwichInterface();
        DrinksInterface drinksInterface = new DrinksInterface();
        ChipsInterface chipsInterface = new ChipsInterface();

        while (true) {
            printlnColor("""
                =================================================
                                 Order Menu
                =================================================
                    Please select from the following choices:
                    1 - Add Sandwich
                    2 - Add Drink
                    3 - Add Chips
                    4 - Checkout
                    0 - Cancel Order
                =================================================
                """, CYAN);

            int userChoice = promptInt("Choose: ");
            switch (userChoice) {
                case 1 -> sandwichInterface.processAddSandwich();
                case 2 -> drinksInterface.processAddDrinks();
                case 3 -> chipsInterface.processAddChips();
                case 4 -> {
                    processCheckout();
                    return;
                }
                case 0 -> {
                    orderList.clearOrder();
                    printlnColor("Order cancelled. Returning to Home.", YELLOW);
                    return;
                }
                default -> printlnColor("Invalid entry. Try again.", RED);
            }
        }
    }

    public void processCheckout() {
        printlnColor("\n=================================================\n               ORDER SUMMARY\n=================================================\n", BLUE);
        println(orderList.toString());

        printlnColor("""
            =================================================
                            CHECKOUT
            =================================================
                Please select from the following choices:
                1 - Confirm Checkout
                2 - Cancel Order
                0 - Back
            =================================================
            """, CYAN);

        while (true) {
            int choice = promptInt("Choose: ");
            switch (choice) {
                case 1 -> {
                    // Confirm: write receipt
                    OrderFileManager.writeOrderReceipt(orderList.toString());
                    printlnColor("Order confirmed and receipt saved. Thank you for your purchase!!", GREEN);
                    orderList.clearOrder();
                    return;
                }
                case 2 -> {
                    orderList.clearOrder();
                    printlnColor("Order cancelled. Returning to home screen.", YELLOW);
                    return;
                }
                case 0 -> {
                    return;
                }
                default -> printlnColor("Invalid selection. Please try again.", RED);
            }
        }
    }
}
