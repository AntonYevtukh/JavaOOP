package homework.lection02.task02;

public class BooksRunner {

    public static void main(String[] args) {

        Books booklist = initializeBooks();
        String separator = "**********************************************************\n";

        System.out.println("The original book list is:\n");
        System.out.println(booklist);
        System.out.println(separator);

        System.out.println("The result of search by authors Ильин, Позняк:\n");
        System.out.println(booklist.searchByAuthor("Ильин").searchByAuthor("Позняк"));
        System.out.println(separator);

        System.out.println("The result of search by publisher McGraw-Hill Education:\n");
        System.out.println(booklist.searchByPublisher("McGraw-Hill Education"));
        System.out.println(separator);

        System.out.println("The result of search by year 2010:\n");
        System.out.println(booklist.searchByYear(2010));
        System.out.println(separator);
    }

    public static Books initializeBooks() {
        Book thinkingInJava = new Book();
        thinkingInJava.setIsbn("9780131872486");
        thinkingInJava.setTitle("Thinking in Java, 4th edition");
        thinkingInJava.setAuthors("Bruce Eckel");
        thinkingInJava.setPublisher("Prentice Hall");
        thinkingInJava.setYear(2006);
        thinkingInJava.setPages(1057);
        thinkingInJava.setPrice(18.58);
        thinkingInJava.setCover("Soft");

        Book javaBeginnerGuide = new Book();
        javaBeginnerGuide.setIsbn("9780071809252");
        javaBeginnerGuide.setTitle("Java: A Beginner's Guide Sixth Edition");
        javaBeginnerGuide.setAuthors("Herbert Schildt");
        javaBeginnerGuide.setPublisher("McGraw-Hill Education");
        javaBeginnerGuide.setYear(2014);
        javaBeginnerGuide.setPages(700);
        javaBeginnerGuide.setPrice(20.68);
        javaBeginnerGuide.setCover("Soft");

        Book javaCompleteReference = new Book();
        javaCompleteReference.setIsbn("9780071808552");
        javaCompleteReference.setTitle("Java: The Complete Reference Ninth Edition");
        javaCompleteReference.setAuthors("Herbert Schildt");
        javaCompleteReference.setPublisher("McGraw-Hill Education");
        javaCompleteReference.setYear(2014);
        javaCompleteReference.setPages(1300);
        javaCompleteReference.setPrice(35.37);
        javaCompleteReference.setCover("Soft");

        Book linearAlgebra = new Book();
        linearAlgebra.setIsbn("9785922104814");
        linearAlgebra.setTitle("Линейная алгебра");
        linearAlgebra.setAuthors("Ильин Владмир Александрович, Позняк Эдуард Генрихович");
        linearAlgebra.setPublisher("Физматлит");
        linearAlgebra.setYear(2014);
        linearAlgebra.setPages(280);
        linearAlgebra.setPrice(663 / 59.6564);
        linearAlgebra.setCover("Твердая 7Б");

        Book nineteenEightyFour = new Book();
        nineteenEightyFour.setIsbn("9780881030365");
        nineteenEightyFour.setTitle("1984");
        nineteenEightyFour.setAuthors("George Orwell");
        nineteenEightyFour.setPublisher("Turtleback Books");
        nineteenEightyFour.setYear(1950);
        nineteenEightyFour.setPages(336);
        nineteenEightyFour.setPrice(10.79);
        nineteenEightyFour.setCover("Soft");

        Book defaultBook = new Book();

        Books booklist = new Books();
        booklist.add(thinkingInJava);
        booklist.add(javaBeginnerGuide);
        booklist.add(javaCompleteReference);
        booklist.add(linearAlgebra);
        booklist.add(nineteenEightyFour);
        booklist.add(defaultBook);

        return booklist;
    }
}
