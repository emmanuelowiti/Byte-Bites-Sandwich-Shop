package com.pluralsight;

import com.pluralsight.Drinks;
import com.pluralsight;
import java.util.List;

import static com.pluralsight.OrderScreen.scanner;
import static com.pluralsight.UserInterface.orderList;

public class DrinksInterface {
    //ADD DRINKS
    public void processAddDrinks() {
        String drinkFlavor;
        String drinkSize;

        ///DRINK FLAVOR SELECTION
        List<String> drinkFlavorList = new Drinks().getDrinkFlavorList();  //GET DRINK FLAVOR LIST

        do {
            try {
                System.out.println("==========================================");
                System.out.println("         🥤 Choose Your Drink Flavor 🥤   ");
                System.out.println("==========================================");

                //gets options from the drink flavor list
                for (int i = 0; i < drinkFlavorList.size(); i++) {
                    System.out.println("   " + (i + 1) + " - " + drinkFlavorList.get(i));
                }
                System.out.println("   0 - Cancel Order");
                System.out.println("==========================================");

                int flavorChoice = scanner.nextInt();
                scanner.nextLine();

                if (flavorChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                }
                //conditions is more than 1 and less than drink flavor list, get index that's -1 of number you choose
                if (flavorChoice >= 1 && flavorChoice <= drinkFlavorList.size()) {
                    drinkFlavor = drinkFlavorList.get(flavorChoice - 1);
                    System.out.println("You selected: " + drinkFlavor);
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        ///DRINK SIZE SELECTION
        do {
            try {
                System.out.println("""
                   ==========================================
                            🥤 Select Drink Size 🥤
                   ==========================================
                   1 - Small
                   2 - Medium
                   3 - Large
                   0 - Cancel Order
                   ==========================================""");

                int sizeChoice = scanner.nextInt();
                scanner.nextLine();

                if (sizeChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                } else if (sizeChoice == 1) {
                    drinkSize = "Small";
                    break;
                } else if (sizeChoice == 2) {
                    drinkSize = "Medium";
                    break;
                } else if (sizeChoice == 3) {
                    drinkSize = "Large";
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (true);

        //create drinks with flavor and size then save it to the constructor and add to order
        Drinks drink = new Drinks(drinkFlavor, drinkSize);
        orderList.addItems(drink);
        System.out.println(drinkFlavor + " (" + drinkSize + ") added to order.");
    }
}