package org.Rooms;

import java.util.Scanner;
import org.Metods.RoomActions; // Импортируем класс RoomActions

public class Laboratory extends Room {
    @Override public void enter() {
        Scanner scanner = new Scanner(System.in);
        int currentRoom = 2; // Пример значения дл текущей комнаты (укажите нужное значение)

        System.out.println("Вы вошли в Лабораторию. На столе стоят три колбы с жидкостями." +
                "\nНа каждой написано: '\u001B[33mЖелтая\u001B[0m - жизнь, \u001B[34mСиняя\u001b[0m - смерть, \u001B[31mКрасная\u001b[0m- любовь'.");

        boolean inLaboratory = true;
        while (inLaboratory) {
            System.out.println("Какую колбу вы выберете? (введите 'желтая', 'синяя' или 'красная')");
            System.out.println("Или введите 'Вернуться' для выхода в главный зал.");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("желтая")) {
                System.out.println("Вы правильно выбрали колбу! Дверь в лабораторию открыта.");
                inLaboratory = false; // Выходим из лаборатории, чтобы вернуться в главный зал

                // Вызов метода handleRoomActions с двумя аргументами
                RoomActions.handleRoomActions(currentRoom, scanner);
            } else if (answer.equalsIgnoreCase("Вернуться")) {
                System.out.println("Вы вернулись в Главный Зал.");
                inLaboratory = false; // Выходим из лаборатории, чтобы вернуться в главный зал
            } else {
                System.out.println("Вы сделали неправильный выбор. Попробуйте снова или вернитесь в главный зал.");
            }
        }
    }
}
