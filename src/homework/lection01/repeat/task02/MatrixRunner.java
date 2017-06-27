package homework.lection01.repeat.task02;

public class MatrixRunner {

    public static void main(String[] args) {
        Matrix a = new Matrix(5, 25);

        System.out.println("Original matrix");
        System.out.println(a);

        a.rotateQuarters(1);
        System.out.println("After rotating 90");
        System.out.println(a);

        a.rotateQuarters(3);
        System.out.println("After rotating 270");
        System.out.println(a);

        a.rotateDegrees(180);
        System.out.println("After rotating 180");
        System.out.println(a);
    }
}
