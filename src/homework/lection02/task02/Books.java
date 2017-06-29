package homework.lection02.task02;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Books
{
    private ArrayList<Book> books;

    Books() {
        this(new ArrayList<>());
    }

    Books(ArrayList<Book> books) {
        this.books = books;
    }

    public void add(Book book) {
        if (!books.contains(book))
            books.add(book);
    }

    Books searchByAuthor(String author) {
        Books result = new Books();
        for (Book book : books)
            if (book.getAuthors().contains(author))
                result.add(book);
        return result;
    }

    Books searchByPublisher(String author) {
        Books result = new Books();
        for (Book book : books)
            if (book.getPublisher().equals(author))
                result.add(book);
        return result;
    }

    Books searchByYear(int year) {
        Books result = new Books();
        for (Book book : books)
            if (book.getYear() > year)
                result.add(book);
        return result;
    }

    public String toString() {
        if (!books.isEmpty()) {
            String separator = "--------------------------------------------------------\n";
            StringJoiner joiner = new StringJoiner(separator, separator, separator);
            for (Book book : books) {
                joiner.add(book.toString());
            }
            return joiner.toString();
        }
        else return "This book package is empty.";
    }
}
