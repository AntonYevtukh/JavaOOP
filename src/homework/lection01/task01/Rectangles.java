package homework.lection01.task01;

import java.util.ArrayList;

public class Rectangles {
    private ArrayList<Rectangle> rectangles;

    Rectangles() {
        rectangles = new ArrayList<>();
    }

    public void add(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public double summaryArea() {
        double summaryArea = 0;
        for (Rectangle rectangle : rectangles) {
            summaryArea += rectangle.area();
        }
        return summaryArea;
    }

    public String toString() {
        StringBuilder summaryInfo;

        if (!rectangles.isEmpty()) {
            summaryInfo = new StringBuilder("This rectangle package contains the following rectangles:\n");
            for (Rectangle rectangle : rectangles)
                summaryInfo.append(rectangle.toString()).append("\n");
        }
        else
            summaryInfo = new StringBuilder("This rectangle package is empty.");
        return summaryInfo.toString();
    }
}
