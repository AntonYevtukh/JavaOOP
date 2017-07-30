package homework.lection09.task01;

import java.util.*;

/**
 * Created by Anton on 30.07.2017.
 */
public class PersonRunner {

    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();

        peopleList.add(new Person("Anton", 26));
        peopleList.add(new Person("Vladimir", 24));
        peopleList.add(new Person("Anton", 23));
        peopleList.add(new Person("Pavel", 28));
        peopleList.add(new Person("Vladimir", 42));

        System.out.println("List of people (may contain several persons with duplicating names):");
        peopleList.forEach(System.out::println);

        Set<Person> peopleSet = new TreeSet<>(Comparator.comparing(Person::getName));
        peopleSet.addAll(peopleList);

        System.out.println("\nSet of people, ordered by names in ascending alphabetical order\n" + "" +
                "(does not contain persons with duplicating names):");
        peopleSet.forEach(System.out::println);
    }
}
