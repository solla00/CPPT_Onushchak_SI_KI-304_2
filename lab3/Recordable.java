package lab3;


public abstract interface Recordable {
    void startRecording(String fileName);
    void stopRecording();
    void playRecordings();
}
