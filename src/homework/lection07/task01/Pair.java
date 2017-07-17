package homework.lection07.task01;

/**
 * Created by Anton on 16.07.2017.
 */
public class Pair<L, R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Pair: Left is " + left.toString() + ", right is " + right.toString() + ".";
    }
}
