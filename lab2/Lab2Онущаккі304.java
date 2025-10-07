package lab2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Class <code>Lab2Онущаккі304</code> models Audio Player functionality
 * with playlist management, playback and volume control.
 *
 * @author Onushchak
 * @version 1.1
 */
public class Lab2Онущаккі304 {

    private String playerName;
    private List<String> playlist;
    private int currentTrackIndex;
    private boolean isPlaying;
    private int volume;
    private String playbackMode;
    private PrintWriter logWriter;

    public Lab2Онущаккі304(String playerName, List<String> initialTracks, int defaultVolume) throws FileNotFoundException {
        this.playerName = playerName;
        this.playlist = new ArrayList<>(initialTracks);
        this.currentTrackIndex = 0;
        this.isPlaying = false;
        this.volume = Math.max(0, Math.min(100, defaultVolume));
        this.playbackMode = "Normal";
        this.logWriter = new PrintWriter("audioplayer_log.txt");
    }

    // ========== Methods ==========

    public void play() {
        if (!playlist.isEmpty()) {
            isPlaying = true;
            System.out.println("Playing: " + playlist.get(currentTrackIndex));
        }
    }

    public void pause() {
        isPlaying = false;
        System.out.println("Playback paused");
    }

    public void stop() {
        isPlaying = false;
        currentTrackIndex = 0;
        System.out.println("Playback stopped");
    }

    public void nextTrack() {
        if (!playlist.isEmpty()) {
            currentTrackIndex = (currentTrackIndex + 1) % playlist.size();
            System.out.println("Next track: " + playlist.get(currentTrackIndex));
        }
    }

    public void addTrack(String track) {
        playlist.add(track);
        System.out.println("Added track: " + track);
    }

    public void removeTrack(String track) {
        if (playlist.remove(track)) {
            System.out.println("Removed track: " + track);
        }
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("Volume set to " + this.volume + "%");
    }

    public void setPlaybackMode(String mode) {
        this.playbackMode = mode;
        System.out.println("Playback mode changed to: " + mode);
    }

    // ================================
    // Formatted INFO methods
    // ================================

    public void showPlayerInfo() {
        System.out.println("------------------- Player Info -------------------");
        System.out.println("Name         : " + playerName);
        System.out.println("Playlist     : " + playlist.size() + " tracks");
        System.out.println("Volume       : " + volume + "%");
        System.out.println("PlaybackMode : " + playbackMode);
        System.out.println("Is Playing?  : " + (isPlaying ? "Yes" : "No"));
        System.out.println("---------------------------------------------------");
    }

    public void showPlaylist() {
        System.out.println("------------------- Playlist ----------------------");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
        System.out.println("---------------------------------------------------");
    }

    public void showFinalStatus() {
        System.out.println("------------------- Final Status ------------------");
        System.out.println("Name         : " + playerName);
        System.out.println("Current Track: " + (playlist.isEmpty() ? "None" : playlist.get(currentTrackIndex)));
        System.out.println("Volume       : " + volume + "%");
        System.out.println("PlaybackMode : " + playbackMode);
        System.out.println("Is Playing?  : " + (isPlaying ? "Yes" : "No"));
        System.out.println("Playlist     :");
        for (String track : playlist) {
            System.out.println("   - " + track);
        }
        System.out.println("---------------------------------------------------");
    }
}