package ui;

import java.util.Scanner;

public class Input {

    public static double input(Scanner scanner) {
        double value;
        while(true) {
            try {
                value = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Input error. Try again:");
            }
        }
        return value;
    }
}
