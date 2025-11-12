package com.pluralsight;

/**
 * Base item class.
 */
public abstract class Items {
    private String name;
    private int quantity;

    protected Items() { }

    protected Items(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public abstract double calculatePrice();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + (quantity > 0 ? " x" + quantity : "");
    }
}
