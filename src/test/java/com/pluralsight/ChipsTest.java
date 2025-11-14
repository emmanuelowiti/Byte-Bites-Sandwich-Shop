package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipsTest {

    @Test
    void calculatePriceOfChips() {
        //arrange
        Chips ruffles = new Chips();
        Chips lays = new Chips("lays");
        Chips funyons = new Chips("funyons");

        //act
        //Chips cost the same regardless of the type
        double ruffles_expected = 2.69;
        double lays_expected = 2.69;
        double funyons_expected = 2.69;

        double ruffles_price = ruffles.calculatePrice();
        double lays_price = lays.calculatePrice();
        double funyons_price = funyons.calculatePrice();

        //assert

        assertEquals(ruffles_expected,ruffles_price);
        assertEquals(lays_expected,lays_price);
        assertEquals(funyons_expected,funyons_price);
    }
}