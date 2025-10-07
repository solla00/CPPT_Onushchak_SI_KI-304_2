package lab3;

import java.io.*;
import java.util.*;

/**
 * Абстрактний клас AudioDevice (на основі Lab2Онущаккі304)
 * описує базову функціональність аудіопристрою.
 */
public abstract class Lab3Онущаккі304 {

    protected String deviceName;
    protected boolean isOn;
    protected int volume;

    public Lab3Онущаккі304(String deviceName, int defaultVolume) {
        this.deviceName = deviceName;
        this.isOn = false;
        this.volume = Math.max(0, Math.min(100, defaultVolume));
    }

    // Увімкнути пристрій
    public void powerOn() {
        isOn = true;
        System.out.println(deviceName + " увімкнено");
    }

    // Вимкнути пристрій
    public void powerOff() {
        isOn = false;
        System.out.println(deviceName + " вимкнено");
    }

    // Налаштування гучності
    public void setVolume(int newVolume) {
        volume = Math.max(0, Math.min(100, newVolume));
        System.out.println("Гучність встановлено: " + volume + "%");
    }

    // Абстрактні методи (кожен підклас мусить реалізувати)
    public abstract void start();
    public abstract void stop();
}