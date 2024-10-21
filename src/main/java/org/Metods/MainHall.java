package org.Metods;

import org.Rooms.Garden;
import org.Rooms.Laboratory;
import org.Rooms.Library;
import org.SpecialClass.Quest;
import org.Metods.RightInput;
import java.util.Scanner;

import org.Metods.RightInput;

public class MainHall {
    public static int enterMainHall() {
        Scanner scanner = new Scanner(System.in);
        int currentRoom = 0;

        while (true) {
            System.out.println("Вы находитесь в Главном Зале. Перед вами 3 двери с табличками: ");
            System.out.println("1. Библиотека");
            System.out.println("2. Лаборатория");
            System.out.println("3. Сад");
            System.out.println("Введите номер вашего выбора: ");

            Quest.rooms = RightInput.getValidInput(1, 3, scanner);

            switch (Quest.rooms) {
                case 1:
                    currentRoom = 1; // Устанавливаем текущую комнату
                    new Library().enter();
                    break;
                case 2:
                    currentRoom = 2; // Устанавливаем текущую комнату
                    new Laboratory().enter();
                    break;
                case 3:
                    currentRoom = 3; // Устанавливаем текущую комнату
                    new Garden().enter();
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 3.");
                    break;
            }

            if (currentRoom == 0) {
                return currentRoom;
            }
        }
    }
}
