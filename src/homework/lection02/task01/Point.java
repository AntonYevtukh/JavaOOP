package homework.lection02.task01;

public class Point {

    final private char name;
    final private double x;
    final private double y;

    Point() {
        name = '0';
        this.x = 0.0;
        this.y = 0.0;
    }

    Point(char name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return name + "(" + x + ", " + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public char getName() {
        return name;
    }
}
