package org.Rooms;

import org.Metods.RoomActions; // Импортируем класс RoomActions
import org.Rooms.Сontent.GardenSecret;

import java.util.Scanner;

public class Garden extends Room {
    @Override public void enter() {
        Scanner scanner = new Scanner(System.in);
        int currentRoom = 2; // Пример значения для текущей комнаты
        System.out.println("\nВы вошли в Сад с фонтаном. Сад напоминает оранжерею, из которой, как вам кажется, тоже нет выхода. Но тут очень тихо и спокойно." +
        "\nВ таком случае вы можете немного расслабиться тут, но на всякий случай оставайтесь на чеку...");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean inGarden = true;
        while (inGarden) {
            System.out.println("Вы вдруг замечаете странный" + "\u001B[34m" + " блуждающий огонек" + "\u001B[0m" + ". Вы хотите:");
            System.out.println("1. Следовать за ним.");
            System.out.println("2. Оставаться в саду и исследовать его.");
            System.out.println("3. Вернуться в главный зал.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Вы следуете за огоньком...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    new GardenSecret().secretRoom(); // Вызываем метод secretRoom
                    break; // Добавлено break для выхода из switch
                    case 2:
                    System.out.println("Вы решили остаться в саду и исследовать его.");
                    boolean exploringGarden = true;
                    while (exploringGarden) {
                        System.out.println("Выберите действие:");
                        System.out.println("1. Исследовать сад.");
                        System.out.println("2. Вернуться в начало сада.");
                        int action = scanner.nextInt();
                        switch (action) {
                            case 1:
                                System.out.println("Вы исследуете сад и находите красивое цветущее растение.");
                                break;
                            case 2:
                                System.out.println("Вы вернулись в начало сада");
                                exploringGarden = false; // Выходим из подцикла, чтобы вернуться в главный зал
                                break;
                            default:
                                System.out.println("Неверный выбор. Пожалуйста, выберите 1 или 2.");
                                break;
                        }
                    }
                    // После выхода из подцикла возвращаемся в основной цикл
                    break;

                case 3:
                    System.out.println("Вы вернулись в Главный Зал.");
                    inGarden = false; // Выходим из основного цикла
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите 1, 2 или 3.");
                    break;
            }
        }
    }
}
