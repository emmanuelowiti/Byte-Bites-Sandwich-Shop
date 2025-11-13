package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds list of Items in the current order and formats a receipt.
 */
public class Orders implements CalculatePrice {

    private final List<Items> itemList = new ArrayList<>();

    public void addItems(Items items) {
        itemList.add(0, items); // newest first
    }

    public void clearOrder() {
        itemList.clear();
    }

    @Override
    public double calculatePrice() {
        return itemList.stream().mapToDouble(Items::calculatePrice).sum();
    }

    public int countSandwiches() {
        return (int) itemList.stream().filter(i -> i instanceof Sandwich).count();
    }

    public int countDrinksChips() {
        return (int) itemList.stream().filter(i -> i instanceof Drinks || i instanceof Chips).count();
    }

    public boolean isValid() {
        if (countSandwiches() == 0 && countDrinksChips() == 0) return false;
        return true;
    }

    @Override
    public String toString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("Receipt:\nDate: ").append(now.format(fmt)).append("\n");
        sb.append("------------------------------------------------\n");
        for (Items item : itemList) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("------------------------------------------------\n");
        sb.append("Total: $").append(String.format("%.2f", calculatePrice())).append("\n");
        sb.append("------------------------------------------------\n");
        return sb.toString();
    }
}
