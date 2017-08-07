package homework.lection11.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Anton on 06.08.2017.
 */
public class FactorialCreator implements Runnable {

    private AtomicInteger counter = new AtomicInteger(0);
    private int multiplier;
    private String savePath;

    public FactorialCreator(int multiplier, String savePath) {
        this.savePath = savePath;
        this.multiplier = multiplier;
    }

    private BigInteger getFactorialOf(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Can't calculate factorial of negative argument");

        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    private void saveToFile(BigInteger factorial, String fileName) {

        String[] lines = factorial.toString().split("(?<=\\G..................................................)");
        new File(fileName).getParentFile().mkdirs();
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (String string : lines)
                printWriter.println(string);
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    public void run() {
        int n = counter.incrementAndGet() * multiplier;
        BigInteger factorial = getFactorialOf(n);
        String fileName = savePath + "\\factorial_" + n + ".txt";
        saveToFile(factorial, fileName);
    }
}
