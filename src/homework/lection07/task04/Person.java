package homework.lection07.task04;

/**
 * Created by Anton on 16.07.2017.
 */
public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s; Age: %d", name, age);
    }
}
