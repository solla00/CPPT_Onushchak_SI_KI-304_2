package lab3;

import java.util.ArrayList;
import java.util.List;

public class Dictaphone extends Lab3Онущаккі304 implements Recordable {
    private boolean isRecording;
    private List<String> recordings;

    public Dictaphone(String name, int volume) {
        super(name);
        this.volume = Math.max(0, Math.min(100, volume));
        this.isRecording = false;
        this.recordings = new ArrayList<>();
    }

    @Override
    public void startRecording(String fileName) {
        if (isOn) {
            isRecording = true;
            recordings.add(fileName);
            System.out.println(">> Started recording: " + fileName);
        } else {
            System.out.println("Dictaphone is OFF. Cannot record.");
        }
    }

    @Override
    public void stopRecording() {
        if (isRecording) {
            isRecording = false;
            System.out.println(">> Recording stopped.");
        }
    }

    @Override
    public void playRecordings() {
        if (recordings.isEmpty()) {
            System.out.println("No recordings available.");
        } else {
            System.out.println("\n============== RECORDINGS ====================");
            for (int i = 0; i < recordings.size(); i++) {
                System.out.println((i+1) + ". " + recordings.get(i));
            }
            System.out.println("==============================================\n");
        }
    }

    public void showInfo() {
        System.out.println("============== DICTAPHONE INFO ==============");
        System.out.println("Name        : " + name);
        System.out.println("Power       : " + (isOn ? "ON" : "OFF"));
        System.out.println("Volume      : " + volume + "%");
        System.out.println("Recording   : " + (isRecording ? "Yes" : "No"));
        System.out.println("==============================================");
    }
}