package org.Metods;

import org.SpecialClass.Quest;

import java.util.Random;
import java.util.Scanner;

public class RoomActions {
    public static void handleRoomActions(int currentRoom, Scanner scanner) {
        boolean inRoom = true;
        while (inRoom) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Исследовать комнату ");
            System.out.println("2. Прятаться");
            System.out.println("3. Вернуться в главный зал");
            System.out.print("Введите номер вашего выбора: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    exploreRoom(scanner);
                    break;
                case 2:
                    hide(scanner);
                    break;
                case 3:
                    System.out.println("Вы вернулись в Главный Зал.");
                    inRoom = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    public static void exploreRoom(Scanner scanner) {
        if (Quest.isAwakeMonster()) {
            System.out.println("На вас напал монстр!");
            System.out.println("Выберите: ");
            System.out.println("1. Сражаться ");
            System.out.println("2. Бежать!");

            int choice = scanner.nextInt();
            if (choice == 1) {
                battleMonster();
            } else if (choice == 2) {
                fleeMonster();
            }
        } else {
            System.out.println("Монстра в комнате нет, можно исследовать!");
            switch (Quest.rooms) {
                case 1: // Библиотека
                    System.out.println("Вы нашли книгу, в которой лежал листок. На нём было написано '*A**'. Что бы это могло значить?");
                    break;
                case 2: // Лаборатория
                    System.out.println("Вы нашли элексир повышающий жизнь.");
                    Quest.playerLives++;
                    System.out.println("Оставшиеся жизни: " + Quest.playerLives);
                    break;
                case 3: // Сад
                    System.out.println("В саду вы нашли странный ключ...");
                    break;
                default:
                    System.out.println("Ничего интересного не нашлось.");
                    break;
            }
        }
    }

    private static void battleMonster() {
        if (new Random().nextBoolean()) {
            System.out.println("\u001B[32m" + "Вы победили монстра!" + "\u001B[0m");
            Quest.setAwakeMonster(false);
        } else {
            Quest.playerLives--;
            System.out.println("\u001B[31m" + "Вы проиграли битву!" + "\u001B[0m" + " Оставшиеся жизни: " + Quest.playerLives);
            checkGameOver();
        }
    }

    private static void fleeMonster() {
        if (new Random().nextBoolean()) {
            System.out.println("\u001B[32m" + "Вы убегаете от монстра!" + "\u001B[0m");
            Quest.setAwakeMonster(false);
        } else {
            Quest.playerLives--;
            System.out.println("\u001B[31m" + "Вы не успели убежать! Монстр оказался быстрее:(" + "\u001B[0m" + " Оставшиеся жизни: " + Quest.playerLives);
            checkGameOver();
        }
    }

    private static void checkGameOver() {
        if (Quest.playerLives <= 0) {
            System.out.println("Игра окончена!");
            // Здесь можно добавить логику для завершения игры
        }
    }

    public static void hide(Scanner scanner) {
        if (Quest.isAwakeMonster()) {
            if (new Random().nextBoolean()) {
                System.out.println("\u001B[32m" + "Вы успели спрятаться!" + "\u001B[0m");
                Quest.setAwakeMonster(false);
            } else {
                Quest.playerLives--;
                System.out.println("\u001B[31m" + "Вы не успели спрятаться. " + "\u001B[0m" + "Оставшиеся жизни: " + Quest.playerLives);
                checkGameOver();
            }
        } else {
            System.out.println("Пока монстр спит, вы находите пару безопасных мест.");
            while (true) {
                System.out.println("Выберите: ");
                System.out.println("1. Исследовать комнату ");
                System.out.println("2. Прятаться");
                System.out.println("3. Вернуться в главный зал");
                System.out.print("Введите номер вашего выбора: ");

                int a = scanner.nextInt();
                switch (a) {
                    case 1:
                        exploreRoom(scanner);
                        break;
                    case 2:
                        hide(scanner);
                        break;
                    case 3:
                        System.out.println("Вы вернулись в Главный Зал.");
                        return; // Возвращаемся в главный зал
                    default:
                    System.out.println("Неверный выбор.");
                }
            }
        }
    }
}
