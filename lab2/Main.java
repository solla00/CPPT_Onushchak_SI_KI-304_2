package lab2;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Клас-драйвер для демонстрації роботи Lab2Онущаккі304
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> tracks = Arrays.asList("Track1", "Track2", "Track3");

        Lab2Онущаккі304 player = new Lab2Онущаккі304("SonyPlayer", tracks, 70);

        player.showPlaylist();
        player.play();
        player.next();
        player.setVolume(90);
        player.pause();
        player.stop();
        player.addTrack("NewHit");
        player.showPlaylist();
    }
}