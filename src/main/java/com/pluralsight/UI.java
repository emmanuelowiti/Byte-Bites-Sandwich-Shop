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
    }



