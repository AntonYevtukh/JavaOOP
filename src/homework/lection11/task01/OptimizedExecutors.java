package homework.lection11.task01;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 12.08.2017.
 */
public enum OptimizedExecutors implements Executor {

    OPTIMIZED_PARALLEL_EXECUTOR {
        @Override
        public void execute(int k, int n, String directoryName) {
            Runnable optimizedFactorialCreator = new OptimizedFactorialCreator(k,
                    directoryName + "\\" + this.name().toLowerCase(), false);
            ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(n);
            for (int i = 1; i <= n ; i++) {
                executorService.execute(optimizedFactorialCreator);
            }
            executorService.shutdown();
            try {
                executorService.awaitTermination(5, TimeUnit.MINUTES);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    },

    OPTIMIZED_CONSISTENT_EXECUTOR {
        @Override
        public void execute(int k, int n, String directoryName) {

            FactorialSaver factorialSaver = new FactorialSaver(directoryName + "\\" + this.toString().toLowerCase());
            BigInteger result = BigInteger.ONE;
            for (int i = 1; i <= k * n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
                if (i % k == 0)
                    factorialSaver.saveFactorial(result, i);
            }
        }
    },

    OPTIMIZED_JOIN_PARALLEL_EXECUTOR {
        @Override
        public void execute(int k, int n, String directoryName) {
            Runnable optimizedFactorialCreator = new OptimizedFactorialCreator(k,
                    directoryName + "\\" + this.name().toLowerCase(), true);
            ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(n);
            for (int i = 1; i <= n ; i++) {
                executorService.execute(optimizedFactorialCreator);
            }
            executorService.shutdown();
            try {
                executorService.awaitTermination(5, TimeUnit.MINUTES);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    },
}
