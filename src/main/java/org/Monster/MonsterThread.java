package org.Monster;

import org.SpecialClass.Quest;

public class MonsterThread implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(Quest.monsterSleep * 1000L);
                Quest.setAwakeMonster(true);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Завершение потока при прерывании
            }
        }
    }
}