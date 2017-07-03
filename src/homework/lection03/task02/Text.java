package homework.lection03.task02;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Text {

    private Sentence title;
    private final ArrayList<Sentence> content;

    public Text(Sentence title, Sentence... sentences) {
        this.title = title;
        content = new ArrayList<>();
        for (Sentence sentence : sentences) {
            content.add(sentence);
        }
    }

    public void setTitle(Sentence sentence) {
        this.title = sentence;
    }

    public void setTitle(Word... words) {
        this.title = new Sentence(words);
    }

    public void printTitle() {
        System.out.println(title.toString().toUpperCase());
    }

    public Text append(Sentence... sentences) {
        for (Sentence sentence : sentences)
            content.add(sentence);
        return this;
    }

    public Text append(Word... words) {
        content.add(new Sentence(words));
        return this;
    }

    public Text append(String... strings) {
        content.add(new Sentence(strings));
        return this;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("\n",title.toString().toUpperCase() + "\n","\n");
        for (Sentence sentence : content)
            joiner.add(sentence.toString());
        return joiner.toString();
    }
}
