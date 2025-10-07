package lab2;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> tracks = Arrays.asList("Track1", "Track2", "Track3");
        Lab2Онущаккі304 player = new Lab2Онущаккі304("SonyPlayer", tracks, 75);

        
        player.showPlayerInfo();
        player.showPlaylist();

        
        player.play();
        player.setVolume(90);
        player.nextTrack();
        player.pause();
        player.play();
        player.addTrack("NewHit");
        player.removeTrack("Track2");

        // Final status
        player.showFinalStatus();
    }
}