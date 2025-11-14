package com.pluralsight;

import static com.pluralsight.Console.*;

//Various screens that the user interacts with
public class UserInterface {

    // Shared order list
    public static final Orders orderList = new Orders();

    //displaying homescreen method
    public void homeScreen() {
        while (true) {
            printlnColor("""
                 ===============================================================
                      Byte Bites - where every byte builds a better bite
                 ===============================================================
                    Please select from the following choices:
                    1 - New Order
                    0 - Exit
                 ===============================================================
                """, BLUE);

            int choice = promptInt("Selection made is : ");
            switch (choice) {
                //case 1 runs  the OrderScreen method
                case 1 -> orderScreen();

                //case 0 kicks out the user from the program and closes it
                case 0 -> {
                    printlnColor("Goodbye — thanks for using Byte Bites!", GREEN);
                    return;
                }
                //Error handling for invalid input from the user.
                default -> printlnColor("Invalid entry! Try again.", RED);
            }
        }
    }

    //Displays the order screen method
    public void orderScreen() {
        SandwichInterface sandwichInterface = new SandwichInterface();
        DrinksInterface drinksInterface = new DrinksInterface();
        ChipsInterface chipsInterface = new ChipsInterface();

        //continues running while set to true
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

                    try {
                        Thread.sleep(5000); // 1000 ms = 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                case 0 -> {

                    //Clears the order list
                    orderList.clearOrder();
                    printlnColor("Order cancelled. Returning to Home.", YELLOW);
                    return;
                }
                //Error handling for any lacking or invalid input.
                default -> printlnColor("Invalid entry. Try again.", RED);
            }
        }
    }

    //process checkout menu method.
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

                    try {
                        Thread.sleep(5000); // 1000 ms = 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                case 2 -> {
                    //if order is cancelled it clears the cart/ order list
                    orderList.clearOrder();
                    printlnColor("Order cancelled. Returning to home screen.", YELLOW);
                    return;
                }
                case 0 -> {
                    return;
                }
                //Error handling for any invalid input from the user
                default -> printlnColor("Invalid selection. Please try again.", RED);
            }
        }
    }
}
