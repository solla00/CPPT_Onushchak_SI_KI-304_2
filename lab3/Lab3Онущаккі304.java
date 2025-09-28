/***************************************************************************
* Copyright (c) 2013-2023 Lviv Polytechnic National University.
* All Rights Reserved.
*
* This program and the accompanying materials are made available under 
* the terms of the Academic Free License v. 3.0 which accompanies this 
* distribution, and is available at 
* https://opensource.org/licenses/afl-3-0.php/
*
* SPDX-License-Identifier: AFL-3.0
***************************************************************************/

/**
 * Інтерфейс Recordable містить методи для запису та відтворення.
 */
package lab3;
interface Recordable {
    void startRecording(String fileName);   // почати запис
    void stopRecording();                   // зупинити запис
    void playLastRecording();               // відтворити останній запис
}

/**
 * Інтерфейс Manageable містить методи для керування записами.
 */
interface Manageable {
    void deleteRecording(String fileName);  // видалити запис
    void listRecordings();                  // показати всі записи
}

/**
 * Абстрактний клас Device описує базові характеристики пристрою.
 */
abstract class Device {
    protected String brand;
    protected String model;
    protected boolean isOn;

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isOn = false;
    }

    public abstract void turnOn();
    public abstract void turnOff();

    public String getInfo() {
        return "Пристрій: " + brand + " " + model;
    }
}

/**
 * Клас Dictaphone реалізує інтерфейси Recordable і Manageable,
 * а також розширює абстрактний клас Device.
 */
public class Lab3Онущаккі304 extends Device implements Recordable, Manageable {
    private boolean isRecording;
    private java.util.List<String> recordings;

    public Lab3Онущаккі304(String brand, String model) {
        super(brand, model);
        this.isRecording = false;
        this.recordings = new java.util.ArrayList<>();
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Диктофон увімкнено.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        isRecording = false;
        System.out.println("Диктофон вимкнено.");
    }

    @Override
    public void startRecording(String fileName) {
        if (isOn) {
            isRecording = true;
            recordings.add(fileName);
            System.out.println("Розпочато запис: " + fileName);
        } else {
            System.out.println("Спочатку увімкніть диктофон!");
        }
    }

    @Override
    public void stopRecording() {
        if (isRecording) {
            isRecording = false;
            System.out.println("Запис зупинено.");
        } else {
            System.out.println("Запис не ведеться.");
        }
    }

    @Override
    public void playLastRecording() {
        if (!recordings.isEmpty()) {
            System.out.println("Відтворюється: " + recordings.get(recordings.size() - 1));
        } else {
            System.out.println("Немає записів.");
        }
    }

    @Override
    public void deleteRecording(String fileName) {
        if (recordings.remove(fileName)) {
            System.out.println("Запис \"" + fileName + "\" видалено.");
        } else {
            System.out.println("Запис \"" + fileName + "\" не знайдено.");
        }
    }

    @Override
    public void listRecordings() {
        if (recordings.isEmpty()) {
            System.out.println("Записів немає.");
        } else {
            System.out.println("Список записів:");
            for (String r : recordings) {
                System.out.println("- " + r);
            }
        }
    }

    @Override
    public String getInfo() {
        return "Dictaphone: " + brand + " " + model + ", записів: " + recordings.size();
    }

    /**
     * Демонстрація роботи класу DictaphoneLab3.
     */
    public static void main(String[] args) {
       Lab3Онущаккі304  d = new Lab3Онущаккі304("Sony", "ICD-PX470");

        System.out.println(d.getInfo());
        d.turnOn();
        d.startRecording("lecture1.wav");
        d.stopRecording();
        d.playLastRecording();
        d.startRecording("meeting.mp3");
        d.stopRecording();
        d.listRecordings();
        d.deleteRecording("lecture1.wav");
        d.listRecordings();
        d.turnOff();
    }
}