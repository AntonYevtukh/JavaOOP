package homework.lection02.task02;

public class BooksRunner {

    public static void main(String[] args) {
        Book thinkingInJava = new Book("9780131872486", "Thinking in Java, 4th edition", "Bruce Eckel",
                "Prentice Hall", 2006, 1057, 18.58, "Soft");
        Book javaBeginnerGuide = new Book("9780071809252", "Java: A Beginner's Guide Sixth Edition", "Herbert Schildt",
                "McGraw-Hill Education", 2014, 700, 20.68, "Soft");
        Book javaCompleteReference = new Book("9780071808552", "Java: The Complete Reference Ninth Edition", "Herbert Schildt",
                "McGraw-Hill Education", 2014, 1300, 35.37, "Soft");
        Book linearAlgebra = new Book("9785922104814", "Линейная алгебра", "Ильин Владмир Александрович",
                "Физматлит", 2014, 280, 663 / 59.6564, "Твердая 7Б");
        linearAlgebra.addAuthors("Позняк Эдуард Генрихович");
        Book nineteenEightyFour = new Book();
        nineteenEightyFour.setIsbn("9780881030365");
        nineteenEightyFour.setTitle("1984");
        nineteenEightyFour.setAuthor("George Orwell");
        nineteenEightyFour.setPublisher("Turtleback Books");
        nineteenEightyFour.setYear(1950);
        nineteenEightyFour.setPages(336);
        nineteenEightyFour.setPrice(10.79);
        nineteenEightyFour.setCover("Soft");

        Books booklist = new Books();
        booklist.add(thinkingInJava);
        booklist.add(javaBeginnerGuide);
        booklist.add(javaCompleteReference);
        booklist.add(linearAlgebra);
        booklist.add(nineteenEightyFour);

        System.out.println("The original book list is:");
        System.out.println(booklist);

        System.out.println("The result of search by author Herbert Schildt");
        System.out.println(booklist.searchByAuthor("Herbert Schildt"));

        System.out.println("The result of search by publisher Turtleback Books");
        System.out.println(booklist.searchByPublisher("Turtleback Books"));

        System.out.println("The result of search by year 2010");
        System.out.println(booklist.searchByYear(2010));
    }
}
