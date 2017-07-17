package homework.lection07.task02;

import homework.lection07.task01.Pair;

/**
 * Created by Anton on 16.07.2017.
 */
public class Range<T extends Number & Comparable<T>> {

    private final Pair<T , T> margins;

    public Range(T left, T right) {
        if (left.compareTo(right) < 0)
            margins = new Pair<>(left, right);
        else
            throw new IllegalArgumentException("Left margin " + left.toString() + " is not less than right margin " +
                    right.toString() + ";");
    }

    @Override
    public String toString() {
        return String.format("%8ss range: <%10s, %-10s>;", margins.getLeft().getClass().getSimpleName(),
                margins.getLeft().toString(), margins.getRight().toString());
    }
}
