package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {


    @Test
    void calculatePriceOf4_InchSandwich() {

        // Arrange
        List<Toppings> toppings = new ArrayList<>();
        toppings.add(new Toppings("Cheese", "cheese", true));
        toppings.add(new Toppings("bacon", "meat", true));

        Sandwich sandwich = new Sandwich("White", "4", toppings, "Yes");

        // Act
        double price = sandwich.calculatePrice();

        // Assert
        double expectedPrice = 5.50 + 2.00 + 0.55; // base + cheese + lettuce
        assertEquals(expectedPrice,price);
    }
}