package homework.lection04.task01;

import java.util.*;

public class GameTrain implements Train{

    private final List<Carriage> carriages;
    private int current;

    public GameTrain() {
        Random random = new Random();
        carriages = new ArrayList<>();
        int size = 1 + random.nextInt(20);
        for (int i = 0; i < size; i++) {
            carriages.add(new Carriage(random.nextBoolean()));
        }
        current = random.nextInt(size) - 1;
    }

    public void turnRight() {
        if (current != carriages.size() - 1)
            current++;
        else current = 0;
    }

    public void turnLeft() {
        if (current != 0)
            current--;
        else current = carriages.size() - 1;
    }

    public void lightOn() {
        carriages.get(current).lightOn();
    }

    public void lightOff() {
        carriages.get(current).lightOff();
    }

    public boolean isLightOn() {
        return carriages.get(current).isLightOn();
    }

    public boolean isLength(int expectedLength) {
        return carriages.size() == expectedLength;
    }

    public String toString() {
        return "Train size is " + carriages.size();
    }
}
