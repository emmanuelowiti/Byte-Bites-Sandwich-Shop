package com.pluralsight;
/**
 * Serves as my entry point to my code
 */
public class Main {
    public static void main(String[] args) {
        Console.printlnColor("Welcome to Byte Bites - where every byte builds a better bite! 🥪", Console.CYAN);
        UserInterface ui = new UserInterface();
        ui.homeScreen();

        // Close scanner when exiting
        Console.scanner.close();
    }
}
