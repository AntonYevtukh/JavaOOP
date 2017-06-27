package homework.lection01.task01;

public class Rectangle {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width > 0 ? width : 1.0;
        this.height = height > 0 ? height : 1.0;
    }

    Rectangle(double size) {
        this(size, size);
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public double area() {
        return width * height;
    }

    public String toString() {
        return "Width is " + width + ", height is " + height + ", perimeter is " + perimeter() + ", area is " + area() + ".";
    }
}
