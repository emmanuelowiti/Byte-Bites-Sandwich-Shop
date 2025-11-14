package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Drinks extends Items implements CalculatePrice {

    private String drinkSize;
    private String drinkFlavor;

    //immutable list of drinks for the customer to choose from
    private final List<String> drinkFlavorList = new ArrayList<>(List.of("Diet Coke", "Cherry Pepsi", "Sprite", "Baja blast", "Tropicana", "Water"));

    //Prices of drinks depending on their sizes declared final
    private static final double drinksSmall = 2.0;
    private static final double drinksMedium = 2.5;
    private static final double drinksLarge = 3.0;


    //Constructors
    public Drinks() { }

    public Drinks(String drinkFlavor, String drinkSize) {
        super("Drink", 1);
        this.drinkFlavor = drinkFlavor;
        this.drinkSize = drinkSize;
    }

    //Getter for the list of drinks
    public List<String> getDrinkFlavorList() {
        return drinkFlavorList;
    }

    @Override
    public double calculatePrice() {
        if (drinkSize == null)
            return 0.0;
        return switch (drinkSize.toLowerCase().trim()) {
            case "small" -> drinksSmall;
            case "medium" -> drinksMedium;
            case "large" -> drinksLarge;
            default -> 0.0;
        };
    }
    //ToString method
    @Override
    public String toString() {
        return "Drink: " + drinkFlavor + " (" + drinkSize + ") - $" + String.format("%.2f", calculatePrice());
    }
}
