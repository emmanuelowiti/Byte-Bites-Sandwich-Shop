package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

//Class sandwich extends the interface Calculate price to check out.
public class Sandwich extends Items implements CalculatePrice {

    private String sandwichBread;
    private String sandwichSize;
    private String isToasted;
    private List<Toppings> toppingsList = new ArrayList<>();

    // Fixed prices for the different sandwich prices depending of the sizes
    private static final double sandwichSize4 = 5.50, sandwichSize8 = 7.00, sandwichSize12 = 8.50;

    //Different bread options stored in a List
    private final List<String> breadOptions = new ArrayList<>(List.of("White", "Wheat", "Rye", "Wrap"));

    // constructor for the sandwich class
    public Sandwich() {
    }

    //constructor that  takes parameters
    public Sandwich(String sandwichBread, String sandwichSize, List<Toppings> toppingsList, String isToasted) {
        super("Custom Sandwich", 1);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.toppingsList = new ArrayList<>(toppingsList);
        this.isToasted = isToasted;
    }

    public Sandwich(String name, int quantity, String sandwichBread, String sandwichSize, String isToasted) {
        super(name, quantity);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
    }

    public List<String> getBreadOptions() {
        return breadOptions;
    }

    //Add toppings method which passes in the topping
    public void addTopping(Toppings topping) {
        toppingsList.add(topping);
    }

    @Override
    public double calculatePrice() {
        double base = switch (sandwichSize) {
            case "4" -> sandwichSize4;
            case "8" -> sandwichSize8;
            case "12" -> sandwichSize12;
            default -> 0.0;
        };

        double toppingsCost = toppingsList.stream()
                .mapToDouble(t -> t.calculateToppingCost(sandwichSize))
                .sum();
        return base + toppingsCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Sandwich: ").append(getName() == null ? "Custom Sandwich" : getName()).append("\n");
        sb.append("  Size: ").append(sandwichSize).append("\n");
        sb.append("  Bread: ").append(sandwichBread).append("\n");
        sb.append("  Toasted: ").append(isToasted).append("\n");
        sb.append("  Toppings:\n");
        for (Toppings t : toppingsList) sb.append("    ").append(t.toString()).append("\n");
        sb.append("  Total: $").append(String.format("%.2f", calculatePrice())).append("\n");
        return sb.toString();
    }
}
