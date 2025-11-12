package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

/**
 * Toppings model with cost calculations.
 */
public class Toppings {

    private String toppingName;
    private String toppingType;
    private boolean toppingIsExtra;

    // Fixed options
    private final List<String> meatOptions = new ArrayList<>(List.of("Steak","Ham","Salami","Roast Beef","Chicken","Bacon"));
    private final List<String> cheeseOptions = new ArrayList<>(List.of("American","Provolone","Cheddar","Swiss"));
    private final List<String> regularOptions = new ArrayList<>(List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos",
            "Cucumbers", "Pickles", "Guacamole", "Mushrooms"));
    private final List<String> sauceOptions = new ArrayList<>(List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette", "Au jus"));

    private static final double costMeatSize4 = 1.00, costMeatSize8 = 2.00, costMeatSize12 = 3.00;
    private static final double extraCostMeatSize4 = 0.50, extraCostMeatSize8 = 1.00, extraCostMeatSize12 = 1.50;
    private static final double costCheeseSize4 = 0.75, costCheeseSize8 = 1.50, costCheeseSize12 = 2.25;
    private static final double extraCostCheeseSize4 = 0.30, extraCostCheeseSize8 = 0.60, extraCostCheeseSize12 = 0.90;

    public Toppings() { }

    public Toppings(String toppingName, String toppingType) {
        this(toppingName, toppingType, false);
    }

    public Toppings(String toppingName, String toppingType, boolean toppingIsExtra) {
        this.toppingName = toppingName;
        this.toppingType = toppingType;
        this.toppingIsExtra = toppingIsExtra;
    }

    public String getToppingName() {
        return toppingName;
    }
    public String getToppingType() {
        return toppingType;
    }
    public boolean isToppingIsExtra() {
        return toppingIsExtra;
    }

    public List<String> getMeatOptions() {
        return meatOptions;
    }
    public List<String> getCheeseOptions() {
        return cheeseOptions;
    }
    public List<String> getRegularOptions() {
        return regularOptions;
    }
    public List<String> getSauceOptions() {
        return sauceOptions;
    }

    public double calculateToppingCost(String sandwichSize) {
        if (toppingType == null)
            return 0.0;
        if (toppingType.equalsIgnoreCase("Meat"))
            return calculateMeatCost(sandwichSize);
        if (toppingType.equalsIgnoreCase("Cheese"))
            return calculateCheeseCost(sandwichSize);
        return 0.0;
    }

    private double calculateMeatCost(String sandwichSize) {
        return switch (sandwichSize) {
            case "4" -> toppingIsExtra ? costMeatSize4 + extraCostMeatSize4 : costMeatSize4;
            case "8" -> toppingIsExtra ? costMeatSize8 + extraCostMeatSize8 : costMeatSize8;
            case "12" -> toppingIsExtra ? costMeatSize12 + extraCostMeatSize12 : costMeatSize12;
            default -> 0.0;
        };
    }

    private double calculateCheeseCost(String sandwichSize) {
        return switch (sandwichSize) {
            case "4" -> toppingIsExtra ? costCheeseSize4 + extraCostCheeseSize4 : costCheeseSize4;
            case "8" -> toppingIsExtra ? costCheeseSize8 + extraCostCheeseSize8 : costCheeseSize8;
            case "12" -> toppingIsExtra ? costCheeseSize12 + extraCostCheeseSize12 : costCheeseSize12;
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("- " + (toppingName != null ? toppingName : "Unknown"));
        if ("Meat".equalsIgnoreCase(toppingType) || "Cheese".equalsIgnoreCase(toppingType)) {
            // show example price for 4" as indicator (not perfect, but informative)
            sb.append(" ($").append(String.format("%.2f", calculateToppingCost("4"))).append(")");
        }
        if (toppingIsExtra) sb.append(" (Extra)");
        return sb.toString();
    }
}
