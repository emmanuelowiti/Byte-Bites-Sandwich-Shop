package com.pluralsight;

import java.util.List;

/**
 * Interactive chips prompts.
 */
public class ChipsInterface {

    public void processAddChips() {
        Chips model = new Chips();
        List<String> types = model.getChipsTypeList();
        Console.printlnColor("==========================================", Console.BLUE);
        for (int i = 0; i < types.size(); i++) Console.println("  " + (i + 1) + " - " + types.get(i));
        Console.println("  0 - Cancel");

        int choice = Console.promptInt("Choose chips: ");
        if (choice == 0)
            return;

        if (choice < 1 || choice > types.size()) {
            Console.printlnColor("Invalid choice.", Console.RED);
            return;
        }
        String type = types.get(choice - 1);
        Chips c = new Chips(type);
        UserInterface.orderList.addItems(c);
        Console.printlnColor("Chips added: " + type, Console.GREEN);
    }
}
