package homework.lection01.repeat.task02;

import java.util.Random;
import java.util.StringJoiner;

public class Matrix {

    static private Random generator = new Random();
    final private int[][] a;

    Matrix(int size, int maxValue) {
        if (size <= 0)
            size = 10;
        a = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                a[i][j] = generator.nextInt(maxValue);
    }

    Matrix(int size) {
        this(size, 100);
    }

    Matrix() {
        this(10, 100);
    }

    private void rotateOnce() {
        int n = a.length - 1;
        int temp;
        for (int p = 0; p < a.length / 2; p++) {
            for (int i = 0; i < n - 2 * p; i++) {
                temp = a[p][i + p];
                a[p][i + p] = a[i + p][n - p];
                a[i + p][n - p] = a[n - p][n - i - p];
                a[n - p][n - i - p] = a[n - i - p][p];
                a[n - i - p][p] = temp;
            }
        }
    }

    public void rotateQuarters(int quarters) {
        for (int i = 0; i < quarters % 4; i++)
            rotateOnce();
    }

    public void rotateDegrees(int degrees) {
        switch (degrees)
        {
            case 270:
                rotateOnce();
            case 180:
                rotateOnce();
            case 90:
                rotateOnce();
                break;
            default:
                System.out.println("Invalid parameter. No rotation executed.");
        }
    }

    public String toString() {
        int n = a.length;
        StringBuilder result = new StringBuilder("The matrix is: \n");
        for (int i = 0; i < n; i++) {
            StringJoiner joiner = new StringJoiner("\t","","\n");
            for (int j = 0; j < n; j++)
                joiner.add(Integer.toString(a[i][j]));
            result.append(joiner);
        }
        return result.toString();
    }
}
