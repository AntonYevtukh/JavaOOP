package homework.lection01.task01;

public class RectangleRunner {

    public static void main(String[] args) {
        Rectangles rectangles = new Rectangles();
        Rectangle rectangleOne = new Rectangle(14, 88);
        Rectangle rectangleTwo = new Rectangle(4, 3);
        Rectangle squareOne = new Rectangle(16);
        Rectangle squareTwo = new Rectangle(8);

        rectangles.addRectangle(rectangleOne);
        rectangles.addRectangle(squareOne);
        rectangles.addRectangle(rectangleTwo);
        rectangles.addRectangle(squareTwo);

        System.out.println(rectangles);
    }
}