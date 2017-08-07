package homework.lection11.task01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 06.08.2017.
 */
public enum Executors implements Executor {

    ONE_THREAD_EXECUTOR {
        @Override
        public void execute(int k, int n, String directoryName) {
            Runnable factorialCreator = new FactorialCreator(k, directoryName + "\\" + this.name().toLowerCase());
            for (int i = 1; i <= n; i++) {
                factorialCreator.run();
            }
        }
    },

    CONSISTENT_EXECUTOR {
        @Override
        public void execute(int k, int n, String directoryName) {
            Runnable factorialCreator = new FactorialCreator(k, directoryName + "\\" + this.name().toLowerCase());
            for (int i = 1; i <= n; i++) {
                Thread thread = new Thread(factorialCreator);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
    },

    PARALLEL_EXECUTOR {
        @Override
        public void execute(int k, int n, String directoryName) {
            Runnable factorialCreator = new FactorialCreator(k, directoryName + "\\" + this.name().toLowerCase());
            Thread[] threads = new Thread[n];
            for (int i = 1; i <= n; i++) {
                threads[i - 1] = new Thread(factorialCreator);
                threads[i - 1].start();
            }
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
    },

    EXECUTOR_SERVICE_EXECUTOR {
        @Override
        public void execute(int k, int n, String directoryName) {
            Runnable factorialCreator = new FactorialCreator(k, directoryName + "\\" + this.name().toLowerCase());
            ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(n);
            for (int i = 1; i <= n ; i++) {
                executorService.execute(factorialCreator);
            }
            executorService.shutdown();
            try {
                executorService.awaitTermination(5, TimeUnit.MINUTES);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
