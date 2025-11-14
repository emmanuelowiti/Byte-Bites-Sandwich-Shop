package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

//Class chips(child class) extends Item class(Parent class)
public class Chips extends Items implements CalculatePrice {

    private String chipsType;
    //immutable list of strings for the customer to choose from
    private final List<String> chipsTypeList = new ArrayList<>(List.of("Ruffles flaming hot", "Cheetos Hot", "Lays barbeque","Frito lays Classic","Funyons Sour cream"));

    //Immutable final price of chips
    private static final double chipsPrice = 2.69;

    //Constructors
    public Chips() { }

    public Chips(String chipsType) {
        super("Chips", 1);
        this.chipsType = chipsType;
    }


    //Getter for the List of chips
    public List<String> getChipsTypeList() {
        return chipsTypeList;
    }

    //Calculate price implemented
    @Override
    public double calculatePrice() {
        return chipsPrice;
    }

    //ToString method
    @Override
    public String toString() {
        return "Chips: " + chipsType + " - $" + String.format("%.2f", calculatePrice());
    }
}
