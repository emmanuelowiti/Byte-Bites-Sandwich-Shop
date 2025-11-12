package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Save receipts to receipts/ folder (filename yyyyMMdd-HHmmss.txt).
 */
public class OrderFileManager {

    public static void writeOrderReceipt(String order) {
        String dirPath = "receipts";
        File directory = new File(dirPath);
        if (!directory.exists()) directory.mkdirs();

        LocalDateTime t = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String filename = dirPath + File.separator + t.format(df) + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(order);
            Console.printlnColor("Saved receipt to: " + filename, Console.GREEN);
        } catch (IOException e) {
            Console.printlnColor("Error while saving receipt: " + e.getMessage(), Console.RED);
        }
    }
}
