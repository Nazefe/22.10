package org.SpecialClass;

import org.Metods.GameThread;
import org.Monster.MonsterThread;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Quest {
    public static final String CONFIG_FILE = "C:\\Users\\nazar\\IdeaProjects\\VeselovaQu-master\\src\\main\\java\\org\\SpecialClass\\config.properties";
    public static int rooms;
    public static int monsterSleep;
    public static int playerLives;

    private static boolean awakeMonster = false;

    public void start() {
        loadConfig();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new MonsterThread());
        service.submit(new GameThread());
        service.shutdown();
    }

    public static void loadConfig() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("C:\\Users\\nazar\\IdeaProjects\\VeselovaQu-master\\src\\main\\java\\org\\SpecialClass\\config.properties")) {
            properties.load(input);
            rooms = Integer.parseInt(properties.getProperty("rooms", "20"));
            monsterSleep = Integer.parseInt(properties.getProperty("monster.sleep", "60"));
            playerLives = Integer.parseInt(properties.getProperty("lives", "3"));

            // Проверка значений
            if (rooms != 10 && rooms != 20 && rooms != 30) {
                rooms = 20;
            }
            if (monsterSleep != 60 && monsterSleep != 45 && monsterSleep != 120) {
                monsterSleep = 60;
            }
            if (playerLives < 1 || playerLives > 3) {
                playerLives = 3;
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка загрузки конфигурации! Будут использованы значения по умолчанию.");
            rooms = 20;
            monsterSleep = 60;
            playerLives = 3;
        }
    }

    public static boolean isAwakeMonster() {
        return awakeMonster;
    }

    public static void setAwakeMonster(boolean awake) {
        awakeMonster = awake;
        if (awake) {
            System.out.println("\u001B[35mМонстр проснулся!\u001B[0m"); // Фиолетовый цвет
            } else {
            System.out.println("\u001B[35mМонстр уснул.\u001B[0m"); // Фиолетовый цвет
            }
        }
    }
