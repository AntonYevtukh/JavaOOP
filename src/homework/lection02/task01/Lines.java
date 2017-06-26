package homework.lection02.task01;

import java.util.ArrayList;

public class Lines {
    final private ArrayList<Line> lines;

    Lines() {
        lines = new ArrayList<>();
    }

    public void add(Line line) {
        lines.add(line);
    }

    public double sumLength() {
        double sumLength = 0;
        for (Line line : lines) {
            sumLength += line.getLength();
        }
        return sumLength;
    }

    public Line longestLine() {
        Line longestLine = null;
        double maxLength = 0;


        for (Line line : lines) {
            if (line.getLength() > maxLength) {
                longestLine = line;
                maxLength = line.getLength();
            }
        }

        return longestLine;
    }

    public String toString() {
        StringBuilder summaryInfo;

        if (!lines.isEmpty()) {
            summaryInfo = new StringBuilder("This lines package contains the following lines:\n");
            for (Line line : lines) {
                summaryInfo.append(line.toString()).append("\n");
            }
            summaryInfo.append("Summary line's length is " + String.format("%.4f",sumLength()) + ".\n");
            summaryInfo.append("The longest line is " + longestLine().getStart().getName() + longestLine().getEnd().getName());
        }
        else
            summaryInfo = new StringBuilder("This lines package is empty.");

        return summaryInfo.toString();
    }
}
