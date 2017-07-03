package homework.lection03.task02;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Sentence {

    private final ArrayList<Word> content;

    public Sentence(Word... words) {
        content = new ArrayList<>();
        for (Word word : words)
            content.add(word);
    }

    public Sentence(String... strings) {
        content = new ArrayList<>();
        for (String string : strings)
            content.add(new Word(string));
    }

    public Sentence append(Word... words) {
        for (Word word : words)
            content.add(word);
        return this;
    }

    public Sentence append(String... strings) {
        for (String string : strings)
            content.add(new Word(string));
        return this;
    }

    public String toString() {
        String result;
        StringJoiner joiner = new StringJoiner(" ", " ", ".");
        for (Word word : content)
            joiner.add(word.toString());
        result = joiner.toString();
        return Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }
}
