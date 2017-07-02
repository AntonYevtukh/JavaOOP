package homework.lection04.task01;

import java.util.*;

public class GameTrain2 implements Train{

    private final LinkedList<Carriage> carriages;
    private ListIterator<Carriage> trainIterator;
    private Carriage current;
    private boolean isMovingRight;

    public GameTrain2() {
        Random random = new Random();
        carriages = new LinkedList<>();
        int size = 1 + random.nextInt(20);
        for (int i = 0; i < size; i++) {
            carriages.add(new Carriage(random.nextBoolean()));
        }
        trainIterator = carriages.listIterator(random.nextInt(size));
        current = trainIterator.next();
        isMovingRight = true;
    }

    public void turnRight() {
        if (!isMovingRight) {
            isMovingRight = true;
            turnRight();
        }
        if (trainIterator.hasNext())
            current = trainIterator.next();
        else {
            trainIterator = carriages.listIterator(0);
            current = trainIterator.next();
        }
    }

    public void turnLeft() {
        if (isMovingRight) {
            isMovingRight = false;
            turnLeft();
        }
        if (trainIterator.hasPrevious())
            current = trainIterator.previous();
        else {
            trainIterator = carriages.listIterator(carriages.size() - 1);
            current = trainIterator.next();
            trainIterator.previous();
        }
    }

    public void lightOn() {
        current.lightOn();
    }

    public void lightOff() {
        current.lightOff();
    }

    public boolean isLightOn() {
        return current.isLightOn();
    }

    public boolean isLength(int expectedLength) {
        return carriages.size() == expectedLength;
    }

    public String toString() {
        return "Train size is " + carriages.size();
    }
}
