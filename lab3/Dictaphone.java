package lab3;

import java.util.*;

/**
 * Клас Dictaphone наслідує абстрактний клас Lab2Онущаккі304
 * та реалізує можливість запису й відтворення.
 */
public class Dictaphone extends Lab3Онущаккі304 {

    private List<String> recordings;
    private boolean isRecording;

    public Dictaphone(String name, int defaultVolume) {
        super(name, defaultVolume);
        this.recordings = new ArrayList<>();
        this.isRecording = false;
    }

    @Override
    public void start() {
        if (!isRecording) {
            isRecording = true;
            String rec = "Запис_" + (recordings.size() + 1);
            recordings.add(rec);
            System.out.println("▶ Почався запис: " + rec);
        }
    }

    @Override
    public void stop() {
        if (isRecording) {
            isRecording = false;
            System.out.println(" Запис зупинено");
        } else {
            System.out.println("Немає активного запису для зупинки");
        }
    }

    public void playAll() {
        if (recordings.isEmpty()) {
            System.out.println("Немає записів для відтворення");
        } else {
            System.out.println(" Відтворення всіх записів:");
            for (String rec : recordings) {
                System.out.println(" - " + rec);
            }
        }
    }
}