package homework.lection03.task02;

public class Word {

    private final String content;

    public Word(String content) {
        if (content.trim().lastIndexOf(' ') == -1)
            this.content = content.trim();
        else throw new IllegalArgumentException("Words can't content a space.");
    }

    public String toString() {
        return content;
    }
}
