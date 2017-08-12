package homework.lection11.task01;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Anton on 06.08.2017.
 */
public class FactorialCreator implements Runnable {

    private AtomicInteger counter = new AtomicInteger(0);
    private int multiplier;
    private FactorialSaver factorialSaver;

    public FactorialCreator(int multiplier, String savePath) {
        this.factorialSaver = new FactorialSaver(savePath);
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

    public void run() {
        int i;
        synchronized (this) {
            i = counter.incrementAndGet();
        }
        BigInteger factorial = getFactorialOf(i * multiplier);

        factorialSaver.saveFactorial(factorial, i * multiplier);
    }
}
