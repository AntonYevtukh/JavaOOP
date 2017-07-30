package homework.lection09.task02;

import java.util.*;

/**
 * Created by Anton on 30.07.2017.
 */
public class PersonRunner2 {

    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();

        peopleList.add(new Person("Anton",15));
        peopleList.add(new Person("Pavel", 17));
        peopleList.add(new Person("Andrey", 15));
        peopleList.add(new Person("Kolya", 12));
        peopleList.add(new Person("Alexey",15));
        peopleList.add(new Person("Oksana", 10));
        peopleList.add(new Person("Katya", 25));

        System.out.println("List of people:");
        peopleList.forEach(System.out::println);

        //Хранит как ключ возраст, как значение - список людей этого возраста.
        NavigableMap<Integer, List<Person>> peopleMap = new TreeMap(Comparator.naturalOrder());

        // Заполняет мапу людьми из исходного листа.
        // Если список людей с таким возрастом уже есть (соответствующий возрасту ключ найден),
        // добавить человека в конец списка-значения.
        // Иначе создать новый список-значение, соответствующий этому возрасту-ключу и поместить человека в него.
        for(Person p : peopleList) {
            if (peopleMap.containsKey(p.getAge()))
                peopleMap.get(p.getAge()).add(p);
            else
                peopleMap.put(p.getAge(), new ArrayList<>(Arrays.asList(p)));
        }

        //Все содержимое(значения) мапы
        System.out.println("\nContent of people map, ordered by ages in ascending order\n");
        peopleMap.values().forEach((list -> list.forEach(System.out::println)));

        //Все содержимое сабмапы, содержащей подростков от 12 до 17
        SortedMap<Integer, List<Person>> teenagerMap = peopleMap.subMap(12, 18);
        System.out.println("\nContent of teenagers map, ordered by ages in ascending order\n");
        teenagerMap.values().forEach((list -> list.forEach(System.out::println)));

        //Список людей, содержащихся в мапе, чей возраст является минимальным, больше 18
        System.out.println("\nList of people, that have min age, larger than 18 years");
        List<Person> ceiling18List = peopleMap.ceilingEntry(18).getValue();
        ceiling18List.forEach(System.out::println);

        //Список людей, содержащихся в мапе, чей возраст является максимальным, меньше 18
        System.out.println("\nList of people, that have max age, smaller than 18 years");
        List<Person> floor18List = peopleMap.floorEntry(18).getValue();
        floor18List.forEach(System.out::println);
    }
}
