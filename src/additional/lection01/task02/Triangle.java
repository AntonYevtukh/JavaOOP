package additional.lection01.task02;

public class Triangle {

    private final int a;
    private final int b;
    private final int c;

    Triangle(int a, int b, int c) {
        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else {
            this.a = 1;
            this.b = 1;
            this.c = 1;
        }
    }

    Triangle(Triangle triangle) {
        this.a = triangle.a;
        this.b = triangle.b;
        this.c = triangle.c;
    }

    private int perimeter() {
        return a + b + c;
    }

    public double area() {
        return Math.sqrt(perimeter() / 2 * (perimeter() / 2  - a) * (perimeter() / 2 - b) * (perimeter() / 2 - c));
    }

    public String toString() {
        return "Triangle: a = " + a + ", b = " + b + ", c = " + c + ", perimeter = " + perimeter() + ", area = " + area() + ".";
    }
}
