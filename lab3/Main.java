package lab3;

public class Main {
    public static void main(String[] args) {
        Dictaphone dict = new Dictaphone("Sony Dictaphone", 50);

        dict.showInfo();

        dict.turnOn();
        System.out.println("Sony Dictaphone is now ON.");
        dict.setVolume(70);

        dict.startRecording("Record_1");
        dict.stopRecording();

        dict.startRecording("Record_2");
        dict.stopRecording();

        dict.playRecordings();

        dict.turnOff();
        System.out.println("Sony Dictaphone is now OFF.");
    }
}