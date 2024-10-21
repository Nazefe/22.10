package org.Rooms;

import java.util.Scanner;
import org.Metods.RoomActions; // Импортируем класс RoomActions

public class Library extends Room {
    @Override public void enter() {
        Scanner scanner = new Scanner(System.in);
        int currentRoom = 1; // Пример значения для текущей комнаты

        System.out.println("Вы вошли в Библиотеку. На столе лежит книга с закладкой." +
                "\nВ ней написано: 'Найдите слово, которое объединяет всех этих людей'." +
                "\nНа портретах написаны имена: Шекспир, Толстой, Достоевский, Пушкин.");

        boolean inLibrary = true;
        while (inLibrary) {
            System.out.println("Какое слово вы ищете?");
            System.out.println("Введите 'Вернуться' для выхода в главный зал.");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("литература")) {
                System.out.println("Вы правильно ответили! Дверь открыта.");
                inLibrary = false; // Выходим из библиотеки

                // Вызов метода handleRoomActions с двумя аргументами
                RoomActions.handleRoomActions(currentRoom, scanner);
            } else if (answer.equalsIgnoreCase("Вернуться")) {
                System.out.println("Вы вернулись в Главный Зал.");
                inLibrary = false; // Выходим из библиотеки, чтобы вернуться в главный зал } else {
                System.out.println("Вы сделали неправильный выбор. Попробуйте снова или вернитесь в главный зал.");
            }
        }
    }
}
