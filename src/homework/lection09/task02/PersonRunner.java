package homework.lection09.task02;

import java.util.*;

/**
 * Created by Anton on 30.07.2017.
 */
public class PersonRunner {

    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();

        peopleList.add(new Person("Anton",15));
        peopleList.add(new Person("Pavel", 17));
        peopleList.add(new Person("Andrey", 13));
        peopleList.add(new Person("Kolya", 12));
        peopleList.add(new Person("Alexey",14));
        peopleList.add(new Person("Oksana", 10));
        peopleList.add(new Person("Katya", 25));

        System.out.println("List of people:");
        peopleList.forEach(System.out::println);

        NavigableMap<Integer, Person> peopleMap = new TreeMap(Comparator.naturalOrder());

        peopleList.forEach((Person p) -> peopleMap.put(p.getAge(), p));
        System.out.println("\nContent of people map, ordered by ages in ascending order\n");
        peopleMap.values().forEach(System.out::println);

        SortedMap<Integer, Person> teenagerMap = peopleMap.subMap(12, 18);
        System.out.println("\nContent of teenagers map, ordered by ages in ascending order\n");
        teenagerMap.values().forEach(System.out::println);

        System.out.println("\nPerson, that have min age, larger than 18 years");
        Person ceiling18person = peopleMap.ceilingEntry(18).getValue();
        System.out.println(ceiling18person);

        System.out.println("\nPerson, that have max age, smaller than 18 years");
        Person floor18person = peopleMap.floorEntry(18).getValue();
        System.out.println(floor18person);
    }
}
