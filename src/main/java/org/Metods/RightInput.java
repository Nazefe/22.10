package org.Metods;

import java.util.Scanner;

public class RightInput {
    public static int getValidInput(int min, int max, Scanner scanner) {
        int userInput;
        while (true) {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    System.out.println("Пожалуйста, введите число от " + min + " до " + max + ".");
                }
            } else {
                System.out.println("Неправильный ввод. Пожалуйста, введите число(" + min + "-" + max + ").");
                scanner.next();
            }
        }
    }
}
