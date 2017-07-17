package homework.lection08.task01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anton on 16.07.2017.
 */
public class PersonRunner {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Anton",15));
        people.add(new Person(null, 17));
        people.add(new Person("", 15));
        people.add(new Person("Kolya", 15));
        people.add(new Person("Alexey",15));
        people.add(new Person("  ", 10));
        people.add(new Person("Katya", 25));

        System.out.println("People before changes:\n");
        people.forEach(System.out::println);

        Iterator<Person> personIterator = people.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getName() == null || person.getName().matches("[ ]*"))
                personIterator.remove();
        }

        System.out.println("\nPeople after removing persons with empty or null names:\n");
        people.forEach(System.out::println);
    }
}


