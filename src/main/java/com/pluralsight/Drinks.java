package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Drinks extends Items implements CalculatePrice {

    private String drinkSize;
    private String drinkFlavor;

    private final List<String> drinkFlavorList = new ArrayList<>(List.of("Coke", "Pepsi", "Sprite", "Mountain Dew", "Tropicana", "Arizona"));
    private static final double drinksSmall = 2.0, drinksMedium = 2.5, drinksLarge = 3.0;

    public Drinks() { }

    public Drinks(String drinkFlavor, String drinkSize) {
        super("Drink", 1);
        this.drinkFlavor = drinkFlavor;
        this.drinkSize = drinkSize;
    }

    public List<String> getDrinkFlavorList() { return drinkFlavorList; }

    @Override
    public double calculatePrice() {
        if (drinkSize == null) return 0.0;
        return switch (drinkSize.toLowerCase()) {
            case "small" -> drinksSmall;
            case "medium" -> drinksMedium;
            case "large" -> drinksLarge;
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return "Drink: " + drinkFlavor + " (" + drinkSize + ") - $" + String.format("%.2f", calculatePrice());
    }
}
