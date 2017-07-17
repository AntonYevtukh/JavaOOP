package homework.lection07.task03;

import java.util.*;

/**
 * Created by Anton on 17.07.2017.
 */
public class Names {

    private final List<String> names = new ArrayList<>();

    public Names() {
    }

    public Names(Names otherNames) {
        this.names.addAll(otherNames.names);
    }

    public void addName(String name) {
        names.add(name);
    }

    //Сортировка в прямом алфавтном порядке
    public Names orderAlphabetAsc() {
        //names.sort((String n1, String n2) -> n1.compareTo(n2));
        names.sort(Comparator.naturalOrder());
        return this;
    }

    //Сортировка в обратном алфавтном порядке
    public Names orderAlphabetDesc() {
        //names.sort((String n1, String n2) -> n2.compareTo(n1));
        names.sort(Comparator.reverseOrder());
        return this;
    }

    //Сортировка по длине мени по возрастанию
    public Names orderByLengthAsc() {
        //names.sort((String n1, String n2) -> Integer.compare(n1.length(), n2.length()));
        names.sort(Comparator.comparingInt(String::length));
        return this;
    }

    //Сортировка по длине имени по возростанию, если длины равны - в обратном алфавитном порядке
    public Names orderByLengthAscAndAlphabetDesc() {
        //orderAlphabetDesc();
        //orderByLengthAsc();
        //names.sort(Comparator.comparingInt(String::length).thenComparing((String s) -> s).reversed());
        names.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.reverseOrder()));
        return this;
    }

    //Получене наименьшего в алфавитном порядке имени
    public String getMinName() {
        return Collections.min(names);
    }

    @Override
    public String toString() {
        String header = String.format("%-15s| %8s\n-------------------------\n", "Name", "Length");
        StringJoiner joiner = new StringJoiner("\n", header,"\n");
        for (String name : names)
            joiner.add(String.format("%-15s| %-2d chars", name, name.length()));
        return joiner.toString();
    }
}
