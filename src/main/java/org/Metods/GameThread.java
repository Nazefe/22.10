package org.Metods;

import org.SpecialClass.Quest;

import java.util.Scanner;

public class GameThread implements Runnable {
    private int currentRoom;

    @Override public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (Quest.playerLives > 0) {
                GameIntro.introduceGame();
                currentRoom = MainHall.enterMainHall();
                RoomActions.handleRoomActions(currentRoom, scanner);
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
