package homework.lection11.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 06.08.2017.
 */
public class FactorialRunner {

    private static final String DIRECTORY = System.getProperty("user.dir") + "\\src\\homework\\lection11\\task01\\files";
    private static final String LOGFILE = DIRECTORY + "\\log.txt";
    private static final String SEPARATOR = "--------------------------------------------------------------------------";
    private static final int K = 1000;
    private static final int N = 100;

    public static void main(String[] args) {

        File saveDirectory = new File(DIRECTORY);
        saveDirectory.delete();
        saveDirectory.mkdirs();
        new File(LOGFILE).delete();
        
        printSystemInfo();

        for (Executor executor : OptimizedExecutors.values())
            benchmark(executor, K, N);
    }

    private static void benchmark(Executor executor, int k, int n) {
        LocalTime start;
        LocalTime end;
        Duration duration;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        try (PrintStream printStream = new PrintStream(new FileOutputStream(LOGFILE, true))) {
            PrintHelper printHelper = new PrintHelper(printStream, System.out);
            printHelper.println("Calculating factorials with parameters:");
            printHelper.println("Executor type: " + executor.toString());
            printHelper.println("Number of factorials: (N): " + n);
            printHelper.println("Multiplier (K): " + k);
            start = LocalTime.now();
            printHelper.println("Start time: " + formatter.format(start));
            executor.execute(k, n, DIRECTORY);
            end = LocalTime.now();
            printHelper.println("End time: " + formatter.format(end));
            duration = Duration.between(start, end);
            long s = duration.getSeconds();
            printHelper.println(String.format("Duration: %d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60)));
            printHelper.println(SEPARATOR);
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    private static void printSystemInfo() {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(LOGFILE, true))) {
            PrintHelper printHelper = new PrintHelper(printStream, System.out);
            printHelper.println(String.format("\nSystem info:"));
            printHelper.println(String.format(SEPARATOR));
            printHelper.println(String.format("%-24s: %s", "OS name", System.getProperty("os.name")));
            printHelper.println(String.format("%-24s: %s", "OS architecture", System.getProperty("os.arch")));
            printHelper.println(String.format("%-24s: %s", "OS version", System.getProperty("os.version")));
            printHelper.println(String.format("%-24s: %s", "CPU identifier", System.getenv("PROCESSOR_IDENTIFIER")));
            printHelper.println(String.format("%-24s: %s", "CPU architecture", System.getenv("PROCESSOR_ARCHITECTURE")));
            printHelper.println(String.format("%-24s: %s", "Number of CPU logical threads", System.getenv("NUMBER_OF_PROCESSORS")));
            printHelper.println(String.format("%-24s: %s", "Free memory (MB)", (Runtime.getRuntime().freeMemory() >> 20)));
            printHelper.println(String.format("%-24s: %s", "Maximum memory (MB)", (Runtime.getRuntime().maxMemory() >> 20)));
            printHelper.println(String.format("%-24s: %s", "Total memory (MB)", (Runtime.getRuntime().totalMemory() >> 20)));
            printHelper.println(String.format(SEPARATOR));
            printHelper.println("");
        }
        catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}
