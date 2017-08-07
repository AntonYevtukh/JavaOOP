package homework.lection11.task01;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Anton on 06.08.2017.
 */
public class PrintHelper {

    private PrintStream[] printStreams;

    public PrintHelper(PrintStream... printStreams) {
        this.printStreams = printStreams;
    }

    public void println(String line) {
        for (PrintStream printStream : printStreams)
            printStream.println(line);
    }
}
