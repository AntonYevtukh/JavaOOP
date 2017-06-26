package homework.lection01.task01;

import java.util.ArrayList;

public class Rectangles {
    private ArrayList<Rectangle> rectangles;

    Rectangles() {
        rectangles = new ArrayList<>();
    }

    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public double summaryArea() {
        double summaryArea = 0;
        for (Rectangle rectangle : rectangles) {
            summaryArea += rectangle.area();
        }
        return summaryArea;
    }

    public String toString()
    {
        StringBuilder summaryInfo = new StringBuilder("This rectangle package contains following rectangles:\n");
        for (Rectangle rectangle : rectangles)
            summaryInfo.append(rectangle.toString() + "\n");
        return summaryInfo.toString();
    }
}
