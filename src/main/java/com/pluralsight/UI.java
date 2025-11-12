package com.pluralsight;

import static com.pluralsight.OrderScreen.scanner;

public class UI {

    static Order orderList = new Orders();

    //Showing homescreen method
    public void showHomeScreen(){

        int userChoice;

        String options = """
         ===============================================================
          🥪🥪 Byte Bites - where every byte builds a better bite 🥪🥪
         ===============================================================
            Please select from the following choices:
            1 - New Order
            0 - Exit
         ===============================================================
         """;

        do{
            try{
                userChoice = scanner.nextInt();
                scanner.nextLine();
                switch(userChoice){
                    case 1:
                        orderScreen();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid entry! Try again");
                }
            }catch (Exception e){
                System.out.println("Invalid entry. Please try again." + e.getMessage());
                }
            }while(true);
        }
    }
    //OrderScreen with the list of options
    public void orderScreen(){
        String options = """
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
        """;

        int userChoice;
        do{
            try{
                userChoice = scanner.nextInt();
                scanner.nextLine();
                switch(userChoice) {
                    case 1:
                        new SandwichInterphase().processAddSandwich();
                        break;
                    case 2:
                        new DrinksInterphase().processAddDrinks();
                        break;
                    case 3:
                        new ChipsInterphase().processAddChips();
                        break;
                    case 4:
                        processCheckout();
                        break;
                    case 0:
                        orderList.clearOrder();
                        return;
                    default:
                        System.out.println("Invalid entry. Try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid entry. Try again" + e.getMessage());
            }
        }while(true);
    }
public void processCheckout() {

    System.out.println("""
                
                =================================================
                               ORDER SUMMARY
                =================================================
                """);
    System.out.println(orderList.toString());


    String options = """
        =================================================
                        CHECKOUT
        =================================================
            Please select from the following choices:
            1 - Confirm Checkout
            2 - Cancel Order
            0 - Back
        =================================================
        """;


    int userChoice;
    do {
        try {
            userChoice = scanner.nextInt();
            scanner.nextLine();

            if (userChoice == 1) {
                //confirm checkout
                //writes order lists into a file after turning it into a string
                OrderFileManager.writeOrderReceipt(orderList.toString());
                System.out.println("Order confirmed and receipt saved.");
                System.out.println("Thank you for your purchase!!");
                orderList.clearOrder();
                showHomeScreen(); //return to home screen after checkout
                return;

            } else if (userChoice == 2) {
                //cancel order goes back to home screen
                System.out.println("Order cancelled. Returning to home screen.");
                orderList.clearOrder();
                showHomeScreen();
                return;

            } else if (userChoice == 0) {
                //go back to order screen
                return;

            } else {
                System.out.println("Invalid selection. Please try again.");
            }

        } catch (Exception e) {
            System.out.println("Invalid selection. Please try again." + e.getMessage());
        }
    } while (true);
}




