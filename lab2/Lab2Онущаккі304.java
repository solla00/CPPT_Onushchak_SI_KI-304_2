/***************************************************************************
* Copyright (c) 2013-2023 Lviv Polytechnic National University. All Rights Reserved.
*
* This program and the accompanying materials are made available under the terms
* of the Academic Free License v. 3.0 which accompanies this distribution, and is
* available at https://opensource.org/licenses/afl-3.0.php/
*
* SPDX-License-Identifier: AFL-3.0
***************************************************************************/

/*
* Lab 2 package
*/
package lab2;

import java.io.*;
import java.util.*;

/**
* Class <code>Lab2Онущаккі304</code> implements audio player functionality
* for managing playlists and music playback demonstration
*
* Клас Lab2Онущаккі304 реалізує функціональність аудіоплеєра
* з можливістю управління плейлистами та відтворенням музики
*
* @author Онущаккі304
* @version 1.0
*/
public class Lab2Онущаккі304 {

// Приватні поля класу
private String playerName; // Назва плеєра
private List<String> playlist; // Список треків
private int currentTrackIndex; // Індекс поточного треку
private boolean isPlaying; // Стан відтворення
private int volume; // Рівень гучності (0-100)
private String playbackMode; // Режим відтворення
private PrintWriter logWriter; // Для запису логів

/**
* Constructor
* Конструктор з трьома параметрами для створення аудіоплеєра
*
* @param playerName назва плеєра
* @param initialTracks початковий список треків
* @param defaultVolume початкова гучність (0-100)
* @throws FileNotFoundException якщо не вдається створити лог файл
*/
public Lab2Онущаккі304(String playerName, List<String> initialTracks, int defaultVolume) throws FileNotFoundException {
this.playerName = playerName;
this.playlist = new ArrayList<String>(initialTracks);
this.currentTrackIndex = 0;
this.isPlaying = false;
this.volume = Math.max(0, Math.min(100, defaultVolume)); // Обмеження 0-100
this.playbackMode = "normal";

// Створення лог файлу
this.logWriter = new PrintWriter(new File("audioplayer_log.txt"));

logToFile("AudioPlayer '" + playerName + "' створено успішно!");
logToFile("Завантажено " + playlist.size() + " треків");

System.out.println("Audiopleyir '" + playerName + "' inicializovano");
System.out.println("Zavantazheno trekiv: " + playlist.size());
}

/**
* Constructor
* Альтернативний конструктор з параметром ресурсу
*
* @param resource ресурс для ініціалізації плеєра
* @throws FileNotFoundException якщо ресурс не знайдено
*/
public Lab2Онущаккі304(String resource) throws FileNotFoundException {
this.playerName = "DefaultPlayer";
this.playlist = new ArrayList<String>();
this.currentTrackIndex = 0;
this.isPlaying = false;
this.volume = 50;
this.playbackMode = "normal";

this.logWriter = new PrintWriter(new File("audioplayer_log.txt"));

System.out.println("Створено базовий аудіоплеєр з ресурсу: " + resource);
}

/**
* Method adds new track to playlist
* Метод додає новий трек до плейлиста
*
* @param trackName назва треку для додавання
*/
public void addTrack(String trackName) {
if (trackName != null && !trackName.trim().isEmpty()) {
playlist.add(trackName.trim());
logToFile("Трек '" + trackName + "' додано до плейлиста");
System.out.println("Додано трек: " + trackName);
} else {
System.out.println("Помилка: неправильна назва треку");
}
}

/**
* Method removes track from playlist
* Метод видаляє трек з плейлиста
*
* @param trackName назва треку для видалення
*/
public void removeTrack(String trackName) {
if (playlist.remove(trackName)) {
logToFile("Трек '" + trackName + "' видалено з плейлиста");
System.out.println("Видалено трек: " + trackName);

// Коригуємо поточний індекс якщо потрібно
if (currentTrackIndex >= playlist.size()) {
currentTrackIndex = Math.max(0, playlist.size() - 1);
}
} else {
System.out.println("Трек '" + trackName + "' не знайдено");
}
}

/**
* Method starts playback of current track
* Метод запускає відтворення поточного треку
*/
public void startPlayback() {
if (!playlist.isEmpty()) {
isPlaying = true;
String currentTrack = playlist.get(currentTrackIndex);
logToFile("Почато відтворення: " + currentTrack);

System.out.println("Відтворюється: " + currentTrack);
System.out.println("Гучність: " + volume + "%");
System.out.println("Режим: " + playbackMode);
} else {
System.out.println("Плейлист порожній. Додайте треки для відтворення");
}
}

/**
* Method pauses current playback
* Метод призупиняє поточне відтворення
*/
public void pausePlayback() {
if (isPlaying) {
isPlaying = false;
logToFile("Відтворення призупинено");
System.out.println("Відтворення призупинено");
} else {
System.out.println("Відтворення вже призупинено");
}
}

/**
* Method stops playback and resets to beginning
* Метод зупиняє відтворення та скидає до початку
*/
public void stopPlayback() {
isPlaying = false;
currentTrackIndex = 0;
logToFile("Відтворення зупинено та скинуто до початку");
System.out.println("Відтворення зупинено");
}

/**
* Method switches to next track
* Метод перемикає на наступний трек
*/
public void nextTrack() {
if (!playlist.isEmpty()) {
if (playbackMode.equals("shuffle")) {
// Випадковий трек
currentTrackIndex = new Random().nextInt(playlist.size());
} else {
// Наступний трек по порядку
currentTrackIndex = (currentTrackIndex + 1) % playlist.size();
}

String newTrack = playlist.get(currentTrackIndex);
logToFile("Перемкнуто на наступний трек: " + newTrack);

if (isPlaying) {
System.out.println("Наступний трек: " + newTrack);
}
}
}

/**
* Method switches to previous track
* Метод перемикає на попередній трек
*/
public void previousTrack() {
if (!playlist.isEmpty()) {
currentTrackIndex = (currentTrackIndex - 1 + playlist.size()) % playlist.size();
String newTrack = playlist.get(currentTrackIndex);
logToFile("Перемкнуто на попередній трек: " + newTrack);

if (isPlaying) {
System.out.println("Попередній трек: " + newTrack);
}
}
}

/**
* Method sets volume level
* Метод встановлює рівень гучності
*
* @param newVolume новий рівень гучності (0-100)
*/
public void setVolume(int newVolume) {
int oldVolume = this.volume;
this.volume = Math.max(0, Math.min(100, newVolume));
logToFile("Гучність змінено з " + oldVolume + "% на " + this.volume + "%");
System.out.println("Гучність встановлено: " + this.volume + "%");
}

/**
* Method changes playback mode
* Метод змінює режим відтворення
*
* @param mode новий режим ("normal", "shuffle", "repeat")
*/
public void setPlaybackMode(String mode) {
if (mode.equals("normal") || mode.equals("shuffle") || mode.equals("repeat")) {
String oldMode = this.playbackMode;
this.playbackMode = mode;
logToFile("Режим відтворення змінено з '" + oldMode + "' на '" + mode + "'");
System.out.println("Режим відтворення: " + mode);
} else {
System.out.println("Невідомий режим. Доступні: normal, shuffle, repeat");
}
}

/**
* Method displays current playlist
* Метод відображає поточний плейлист
*/
public void displayPlaylist() {
System.out.println();
System.out.println("Плейлист '" + playerName + "':");
if (playlist.isEmpty()) {
System.out.println(" Плейлист порожній");
return;
}

for (int i = 0; i < playlist.size(); i++) {
String indicator = (i == currentTrackIndex) ? ">> " : " ";
System.out.println(indicator + (i + 1) + ". " + playlist.get(i));
}
System.out.println("Всього треків: " + playlist.size());
}

/**
* Method shows current player status
* Метод відображає поточний статус плеєра
*/
public void showPlayerStatus() {
System.out.println();
System.out.println("Статус аудіоплеєра '" + playerName + "':");
System.out.println("Поточний трек: " + getCurrentTrack());
System.out.println("Статус: " + (isPlaying ? "Відтворюється" : "Призупинено"));
System.out.println("Гучність: " + volume + "%");
System.out.println("Режим: " + playbackMode);
System.out.println("Треків в плейлисті: " + playlist.size());

logToFile("Показано статус плеєра");
}

/**
* Method shuffles the playlist
* Метод перемішує плейлист
*/
public void shufflePlaylist() {
if (playlist.size() > 1) {
Collections.shuffle(playlist);
currentTrackIndex = 0;
logToFile("Плейлист перемішано");
System.out.println("Плейлист перемішано");
} else {
System.out.println("Недостатньо треків для перемішування");
}
}

/**
* Method clears the playlist
* Метод очищує плейлист
*/
public void clearPlaylist() {
int removedTracks = playlist.size();
playlist.clear();
currentTrackIndex = 0;
isPlaying = false;
logToFile("Плейлист очищено. Видалено " + removedTracks + " треків");
System.out.println("Плейлист очищено (" + removedTracks + " треків видалено)");
}

/**
* Private method to get current track name
* Приватний метод для отримання назви поточного треку
*
* @return назва поточного треку або повідомлення про порожній плейлист
*/
private String getCurrentTrack() {
if (playlist.isEmpty()) {
return "Плейлист порожній";
}
return playlist.get(currentTrackIndex);
}

/**
* Private method to log messages to file
* Приватний метод для запису повідомлень до лог файлу
*
* @param message повідомлення для запису
*/
private void logToFile(String message) {
if (logWriter != null) {
logWriter.println(new Date() + ": " + message);
logWriter.flush();
}
}

/**
* Helper method to repeat string (for Java 8 compatibility)
* Допоміжний метод для повторення рядка (сумісність з Java 8)
*
* @param str рядок для повторення
* @param count кількість повторень
* @return повторений рядок
*/
private static String repeatString(String str, int count) {
StringBuilder result = new StringBuilder();
for (int i = 0; i < count; i++) {
result.append(str);
}
return result.toString();
}

// Геттери для доступу до приватних полів
/**
* @return назва плеєра
*/
public String getPlayerName() { return playerName; }

/**
* @return розмір плейлиста
*/
public int getPlaylistSize() { return playlist.size(); }

/**
* @return чи відтворюється музика
*/
public boolean isCurrentlyPlaying() { return isPlaying; }

/**
* @return поточний рівень гучності
*/
public int getCurrentVolume() { return volume; }

/**
* @return поточний режим відтворення
*/
public String getCurrentPlaybackMode() { return playbackMode; }

/**
* Method cleans up resources when object is destroyed
* Метод очищає ресурси при знищенні об'єкта
* Автоматично викликається збирачем сміття
*/
@Override
public void finalize() {
try {
if (logWriter != null) {
logToFile("Аудіоплеєр '" + playerName + "' завершує роботу");
logWriter.close();
}
System.out.println("Аудіоплеєр '" + playerName + "' відключено та очищено");
} catch (Exception e) {
System.err.println("Помилка при завершенні роботи плеєра: " + e.getMessage());
}
}

/**
* Main method for Lab2Онущаккі304 class demonstration
* Головний метод для демонстрації роботи класу Lab2Онущаккі304
*
* @param args аргументи командного рядка
* @throws FileNotFoundException якщо не вдається створити файли
*/
public static void main(String[] args) throws FileNotFoundException {
System.out.println(repeatString("=", 60));
System.out.println(" ДЕМОНСТРАЦІЯ РОБОТИ АУДІОПЛЕЄРА");
System.out.println(" Варіант 16 - Онущаккі304");
System.out.println(repeatString("=", 60));

// Створення початкового плейлиста з популярними українськими треками
List<String> ukrainianTracks = Arrays.asList(
"Okean Elzy - Obijmy",
"Skryabin - Spy sobi sama",
"Boombox - Vahteram",
"TNMK - Dosch",
"Antytila - Tdme"
);

System.out.println();
System.out.println("Створення аудіоплеєра...");
Lab2Онущаккі304 myPlayer = new Lab2Онущаккі304("UkrainianMusicPlayer", ukrainianTracks, 75);

System.out.println();
System.out.println(repeatString("-", 50));
System.out.println("ТЕСТУВАННЯ ОСНОВНИХ ФУНКЦІЙ");
System.out.println(repeatString("-", 50));

// Відображення початкового плейлиста
myPlayer.displayPlaylist();

// Запуск відтворення
System.out.println();
System.out.println("Запуск відтворення:");
myPlayer.startPlayback();

// Зміна гучності
System.out.println();
System.out.println("Налаштування гучності:");
myPlayer.setVolume(90);

// Перемикання треків
System.out.println();
System.out.println("Перемикання треків:");
myPlayer.nextTrack();
myPlayer.nextTrack();

// Показ поточного статусу
myPlayer.showPlayerStatus();

// Додавання нових треків
System.out.println();
System.out.println("Додавання нових треків:");
myPlayer.addTrack("Kalush - Stefania");
myPlayer.addTrack("Go_A - Shum");

// Зміна режиму відтворення на shuffle
System.out.println();
System.out.println("Зміна режиму на shuffle:");
myPlayer.setPlaybackMode("shuffle");

// Перемішування плейлиста
myPlayer.shufflePlaylist();
myPlayer.displayPlaylist();

// Тестування призупинення/відновлення
System.out.println();
System.out.println("Тестування паузи:");
myPlayer.pausePlayback();
System.out.println();
System.out.println("Відновлення відтворення:");
myPlayer.startPlayback();

// Видалення треку
System.out.println();
System.out.println("Видалення треку:");
myPlayer.removeTrack("TNMK - Dosch");

// Тестування попереднього треку
System.out.println();
System.out.println("Попередній трек:");
myPlayer.previousTrack();

// Фінальний статус
System.out.println();
System.out.println(repeatString("-", 50));
System.out.println("ФІНАЛЬНИЙ СТАТУС СИСТЕМИ");
System.out.println(repeatString("-", 50));
myPlayer.showPlayerStatus();
myPlayer.displayPlaylist();

System.out.println();
System.out.println("Тестування різних режимів:");
myPlayer.setPlaybackMode("repeat");
myPlayer.setPlaybackMode("normal");

// Тестування граничних випадків
System.out.println();
System.out.println("Тестування граничних випадків:");
myPlayer.setVolume(150); // Має обмежитись до 100
myPlayer.setVolume(-10); // Має обмежитись до 0
myPlayer.setVolume(50); // Нормальне значення

// Завершення роботи
System.out.println();
System.out.println(repeatString("-", 50));
System.out.println("ЗАВЕРШЕННЯ ДЕМОНСТРАЦІЇ");
System.out.println(repeatString("-", 50));

myPlayer.stopPlayback();
myPlayer.finalize();

System.out.println();
System.out.println("Демонстрація успішно завершена!");
System.out.println("Лог записано у файл: audioplayer_log.txt");
System.out.println(repeatString("=", 60));
}
}