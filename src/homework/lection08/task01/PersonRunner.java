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
        people.add(new Person("Pavel", 17));
        people.add(new Person("Andrey", 15));
        people.add(new Person("Kolya", 15));
        people.add(new Person("Alexey",15));
        people.add(new Person("Oksana", 10));
        people.add(new Person("Katya", 25));

        System.out.println("People before changes:\n");
        people.forEach(System.out::println);

        Iterator<Person> personIterator = people.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getName() == null || person.getName().equals(""))
                people.remove(person);
        }

        System.out.println("People after removing persons with empty or null names:\n");
        people.forEach(System.out::println);
    }
}


