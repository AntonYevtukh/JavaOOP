package homework.lection04.task01;


public class Carriage {

    boolean lightOn;

    public Carriage(boolean lightOn) {
        this.lightOn = lightOn;
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void lightOn() {
        lightOn = true;
    }

    public void lightOff() {
        lightOn = false;
    }
}
