package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Chips extends Items implements CalculatePrice {

    private String chipsType;
    private final List<String> chipsTypeList = new ArrayList<>(List.of("Lays Original", "Cheetos Hot", "Doritos Cool Ranch"));
    private static final double chipsPrice = 1.5;

    public Chips() { }

    public Chips(String chipsType) {
        super("Chips", 1);
        this.chipsType = chipsType;
    }

    public List<String> getChipsTypeList() {
        return chipsTypeList;
    }

    @Override
    public double calculatePrice() {
        return chipsPrice;
    }

    @Override
    public String toString() {
        return "Chips: " + chipsType + " - $" + String.format("%.2f", calculatePrice());
    }
}
