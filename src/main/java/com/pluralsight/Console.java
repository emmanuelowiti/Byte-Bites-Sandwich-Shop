package com.pluralsight;

import java.util.Scanner;

/**
 * Console helper: shared Scanner + ANSI color codes + small prompt utilities.
 */
public final class Console {
    public static final Scanner scanner = new Scanner(System.in);

    // Toggle to false if your terminal doesn't support ANSI codes
    public static boolean USE_COLOR = true;

    public static final String RESET = USE_COLOR ? "\u001B[0m" : "";
    public static final String RED = USE_COLOR ? "\u001B[31m" : "";
    public static final String GREEN = USE_COLOR ? "\u001B[32m" : "";
    public static final String YELLOW = USE_COLOR ? "\u001B[33m" : "";
    public static final String BLUE = USE_COLOR ? "\u001B[34m" : "";
    public static final String CYAN = USE_COLOR ? "\u001B[36m" : "";

    private Console() { /* static helper only */ }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void printlnColor(String s, String color) {
        if (USE_COLOR) System.out.println(color + s + RESET);
        else System.out.println(s);
    }

    public static void printPrompt(String s) {
        if (USE_COLOR) System.out.print(YELLOW + s + RESET);
        else System.out.print(s);
    }

    public static String promptLine(String prompt) {
        printPrompt(prompt);
        return scanner.nextLine().trim();
    }

    public static int promptInt(String prompt) {
        while (true) {
            printPrompt(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                printlnColor("Please enter a valid number.", RED);
            }
        }
    }
}
