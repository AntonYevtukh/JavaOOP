package homework.lection07.task01;

/**
 * Created by Anton on 16.07.2017.
 */
public class PairRunner {

    public static void main(String[] args) {

        System.out.println("String pair:\n" + new Pair<>("Left", "Right"));
        System.out.println("\nBoolean pair:\n" + new Pair<>(false, true));
        System.out.println("\nInteger pair:\n" + new Pair<>(0, 1));
        System.out.println("\nInteger - Boolean pair:\n" + new Pair<>(1, true));
        System.out.println("\nString - Integer pair:\n" + new Pair<>("One", 1));
    }
}
