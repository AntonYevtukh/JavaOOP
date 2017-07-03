package homework.lection03.task02;

public class TextRunner {

    public static void main(String[] args) {

        Sentence funnyStories = new Sentence(new Word("Funny"), new Word("Stories"));
        Text funnyText = new Text(funnyStories);
        funnyText.append("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit");
        funnyText.append("Nam", "volutpat", "erat", "quis", "viverra", "elementum");

        System.out.println(funnyText);

        funnyText.setTitle(new Sentence("Lorem", "ipsum"));
        funnyText.printTitle();
    }
}
