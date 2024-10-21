package org.Rooms.Сontent;

import org.SpecialClass.Quest;

import java.util.Scanner;

public class GardenSecret {
    public void secretRoom() {
        System.out.println("Вы вошли в тайную комнату, скрытую под большим камнем." +
                "\nЭта комната напоминает подвал с длинным коридором, в конце которого стоит стеклянный купол." +
                "\nПо коридору стоят странные камеры заточения, все они закрыты и пусты. Вы чувствуете, что здесь не всё так просто." +
                "\nНеожиданно перед вам появляется табличка.");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final String word = "JAVA";
        final int attemptsMax = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|                              " + "\u001B[31m" + " Внимание! " + "\u001B[0m" + "|");
        System.out.println("|    Попробуйте угадать секретное слово, состоящее из " + word.length() + " букв.|");
        System.out.println("|    У вас есть " + attemptsMax + " попыток.                                     |");
        System.out.println("--------------------------------------------------------------------------------");
        int attempts = 0;
        boolean solved = false;

        while (attempts < attemptsMax) {
            System.out.print("Введите ваше ответ: ");
            String answer = scanner.nextLine().toUpperCase();

            if (answer.equals(word)) {
                solved = true;
                break;
            } else {
                attempts++;
                System.out.println("\u001B[31m" + "Неправильно!" + "\u001B[0m" + " Осталось попыток: " + (attemptsMax - attempts));
            }
        }
        if (solved) {
            System.out.println("Поздравляем! Вы угадали слово: " + word);
            System.out.println("Вы нашли дверь ведущую на свободу!");
            System.out.println("Поздравляю с победой в этой игре! Буду рада видеть вас ещё раз))) Оставшиеся жизни: " + Quest.playerLives);
            System.exit(0);
        } else {
            System.out.println("Вы исчерпали все попытки. Загаданное слово было: " + word);
            System.out.println("Вам не удалось сбежать. Монстр успел вас догнать!");
            System.out.println("Игра окончена. Возвращайтесь ещё, чтобы исследовать новые головоломки этого особняка)");
            System.exit(0);
        }
    }
}
