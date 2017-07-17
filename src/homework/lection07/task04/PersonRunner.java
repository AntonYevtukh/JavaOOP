package homework.lection07.task04;

import java.util.ArrayList;
import java.util.Comparator;
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

        //Сортировка по возрасту в обратном порядке, внутри групп с одинаковым возрастом - по имени в алфавитном порядке
        //Очень сильное колдунство
        people.sort((Comparator.comparingInt(Person::getAge)).reversed().thenComparing(Person::getName));

        System.out.println("\nPeople after sorting - by age descending, if ages are equal, then by names ascending:\n");
        people.forEach(System.out::println);

        //Фильтрация по возрасту - выбирает подростков от 12 до 17 лет
        people.removeIf((Person p1) -> (p1.getAge() < 12 || p1.getAge() > 17));

        System.out.println("\nPeople after filtering - lefts teenagers only (if age is between 12 and 17):\n");
        people.forEach(System.out::println);
    }
}


