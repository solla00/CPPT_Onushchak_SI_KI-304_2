package lab2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Клас <code>Lab2Онущаккі304</code> моделює роботу аудіоплеєра:
 * управління плейлистом, відтворенням та гучністю.
 *
 * @author Онущак
 * @version 1.0
 */
public class Lab2Онущаккі304 {
    private String playerName;
    private List<String> playlist;
    private int currentTrackIndex;
    private boolean isPlaying;
    private int volume;
    private PrintWriter logWriter;

    
    public Lab2Онущаккі304(String playerName, List<String> initialTracks, int defaultVolume) throws FileNotFoundException {
        this.playerName = playerName;
        this.playlist = new ArrayList<>(initialTracks);
        this.currentTrackIndex = 0;
        this.isPlaying = false;
        this.volume = Math.max(0, Math.min(100, defaultVolume));
        this.logWriter = new PrintWriter("audioplayer_log.txt");
        log("Створено плеєр: " + playerName + ", треків: " + playlist.size());
    }

   
    public Lab2Онущаккі304() throws FileNotFoundException {
        this("DefaultPlayer", new ArrayList<>(), 50);
    }

    
    public void play() {
        if (!playlist.isEmpty()) {
            isPlaying = true;
            log("Відтворення: " + playlist.get(currentTrackIndex));
            System.out.println("▶ Відтворюється: " + playlist.get(currentTrackIndex));
        } else {
            System.out.println("Плейлист порожній!");
        }
    }

   
    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            log("Відтворення призупинено");
            System.out.println("⏸ Призупинено");
        }
    }

    
    public void stop() {
        isPlaying = false;
        currentTrackIndex = 0;
        log("Відтворення зупинено");
        System.out.println("⏹ Зупинено");
    }

    
    public void next() {
        if (!playlist.isEmpty()) {
            currentTrackIndex = (currentTrackIndex + 1) % playlist.size();
            log("Наступний трек: " + playlist.get(currentTrackIndex));
            System.out.println("⏭ " + playlist.get(currentTrackIndex));
        }
    }

    
    public void previous() {
        if (!playlist.isEmpty()) {
            currentTrackIndex = (currentTrackIndex - 1 + playlist.size()) % playlist.size();
            log("Попередній трек: " + playlist.get(currentTrackIndex));
            System.out.println("⏮ " + playlist.get(currentTrackIndex));
        }
    }

   
    public void addTrack(String track) {
        playlist.add(track);
        log("Додано трек: " + track);
    }

    
    public void removeTrack(String track) {
        if (playlist.remove(track)) {
            log("Видалено трек: " + track);
        }
    }

    
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        log("Гучність: " + this.volume);
    }

    
    public void showPlaylist() {
        System.out.println("Плейлист:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    
    private void log(String msg) {
        logWriter.println(new Date() + " : " + msg);
        logWriter.flush();
    }

    
    @Override
    protected void finalize() throws Throwable {
        if (logWriter != null) {
            log("Завершення роботи плеєра");
            logWriter.close();
        }
    }
}