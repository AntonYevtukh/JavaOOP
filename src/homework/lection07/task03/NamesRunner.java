package homework.lection07.task03;

/**
 * Created by Anton on 17.07.2017.
 */
public class NamesRunner {

    public static void main(String[] args) {

        Names originalNames = new Names();
        Names modifiedNames;
        originalNames.addName("Anton");
        originalNames.addName("Konstantin");
        originalNames.addName("Pavel");
        originalNames.addName("Nikolay");
        originalNames.addName("Alexandr");
        originalNames.addName("Vladimir");
        originalNames.addName("Bogdan");
        originalNames.addName("Oksana");
        originalNames.addName("Marya");
        originalNames.addName("Anastasia");
        originalNames.addName("Ievgeny");

        System.out.println("Names before sorting\n");
        System.out.println(originalNames);
        modifiedNames = new Names(originalNames);

        System.out.println("Names sorted in ascending alphabetical order:\n");
        System.out.println(modifiedNames.orderAlphabetAsc());
        modifiedNames = new Names(originalNames);

        System.out.println("Names sorted in descending alphabetical order:\n");
        System.out.println(modifiedNames.orderAlphabetDesc());
        modifiedNames = new Names(originalNames);

        System.out.println("Names sorted by length in ascending order:\n");
        System.out.println(modifiedNames.orderByLengthAsc());
        modifiedNames = new Names(originalNames);

        System.out.println("Names sorted by length in ascending order and if\n" +
                "lengths are equal, in descending alphabetical order:\n");
        System.out.println(modifiedNames.orderByLengthAscAndAlphabetDesc());

        System.out.println("The minimal name in ascending alphabet order: " + originalNames.getMinName());

    }
}
