package lab3;

/**
 * Драйвер для перевірки роботи диктофона.
 */
public class Main {
    public static void main(String[] args) {
        Dictaphone dict = new Dictaphone("Sony Dictaphone", 70);

        dict.powerOn();
        dict.setVolume(80);

        dict.start();   
        dict.stop();    

        dict.start();   
        dict.stop();

        dict.playAll(); 

        dict.powerOff();
    }
}