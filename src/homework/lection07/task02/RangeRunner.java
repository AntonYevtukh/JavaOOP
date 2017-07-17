package homework.lection07.task02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 16.07.2017.
 */
public class RangeRunner {

    public static void main(String[] args) {

        Range<Byte> byteRange = new Range<>((byte)8, (byte)16);
        Range<Short> shortRange = new Range<>((short)512, (short) 1024);
        Range<Integer> integerRange = new Range<>(65_536, 131_072);
        Range<Long> longRange = new Range<>(4_294_967_296L, 8_589_934_592L);
        Range<Float> floatRange = new Range<>(14.88f, 99.73f);
        Range<Double> doubleRange = new Range<>(36.6, 97.88);

        List<Range<?>> ranges = new ArrayList<>();

        ranges.add(byteRange);
        ranges.add(shortRange);
        ranges.add(integerRange);
        ranges.add(longRange);
        ranges.add(floatRange);
        ranges.add(doubleRange);

        System.out.println("Range's demo: ");
        ranges.forEach(System.out::println);

        //Попытка создать диапазон с некорректно заданным границами
        System.out.println("\nTry to create range with invalid margins <16, 8>: ");
        try {
            Range<Integer> invalidIntegerRange = new Range<>(16, 8);
        }
        catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace(System.out);
        }

        //Попытка создать диапазон со строками - не скомпилируется
        //Range<String> stringRange = new Range<>("Left", "Right");
    }
}
