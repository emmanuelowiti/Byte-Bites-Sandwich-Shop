package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinksTest {

    @Test
    void calculatePriceOfLargeDrink() {
        // Arrange
        Drinks largeDrink = new Drinks("Sprite", "large");

        // Act
        double price = largeDrink.calculatePrice();

        // Assert
        assertEquals(3.0, price);

    }
    @Test
    void calculatePriceOfSmallDrink() {
        // Arrange
        Drinks smallDrink = new Drinks("Sprite", "small");

        // Act
        double price = smallDrink.calculatePrice();

        // Assert
        assertEquals(2.0, price);

    }
    @Test
    void calculatePriceOfMediumDrink() {
        // Arrange
        Drinks mediumDrink = new Drinks("Sprite", "medium");

        // Act
        double price = mediumDrink.calculatePrice();

        // Assert
        assertEquals(2.5, price);

    }
}