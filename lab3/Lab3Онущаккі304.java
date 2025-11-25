package lab3;


public abstract class Lab3Онущаккі304 {
    protected String name;
    protected int volume;
    protected boolean isOn;

    public Lab3Онущаккі304(String name) {
        this.name = name;
        this.volume = 50;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("Volume of " + name + " set to " + this.volume + "%.");
    }

    public abstract void showInfo(); // абстрактний метод
}