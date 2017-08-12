package homework.lection11.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * Created by Anton on 12.08.2017.
 */
public class FactorialSaver {

    private String savePath;

    public FactorialSaver(String savePath) {
        this.savePath = savePath;
    }

    public void saveFactorial(BigInteger factorial, int argument) {
        String fileName = savePath + "\\factorial_" + argument + ".txt";
        //String[] lines = factorial.toString().split("(?<=\\G..................................................)");
        String factorialString = factorial.toString();
        int lineCount = factorialString.length() / 50;
        new File(fileName).getParentFile().mkdirs();
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int i = 0; i < lineCount; i++)
                printWriter.println(factorialString.substring((i * 50), (i * 50) + 50));
            int factorialLength = factorialString.length();
            printWriter.println(factorialString.substring(factorialLength - (factorialLength % 50), factorialLength));
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}
