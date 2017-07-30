package homework.lection09.task03;

import java.util.*;

/**
 * Created by Anton on 30.07.2017.
 */
public class NumberCounterRunner {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 2, 5, 5, 3, 7, 8, 6, 7, 9, 0, 3, 2, 9));
        System.out.println("List of numbers:");
        System.out.println(integers);

        //Чтобы вывод был упорядоченным
        //Преобразование хэша в позицию вставки не сохраняет порядок
        Map<Integer, Integer> integerToCountMap = new TreeMap<>();

        for (int i : integers)
            if (integerToCountMap.containsKey(i))
                integerToCountMap.put(i, integerToCountMap.get(i) + 1);
            else
                integerToCountMap.put(i, 1);

        System.out.println("Count of integers in the list:");
        integerToCountMap.forEach((Integer number, Integer count) ->
                System.out.printf("Number: %d; Count: %d\n", number, count));
    }
}
