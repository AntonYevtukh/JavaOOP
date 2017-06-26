package homework.lection02.task02;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Book {

    private String isbn; //id
    private String title;
    private ArrayList<String> authors;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String cover;

    Book() {
        this("Unknown", "Unknown", "Unknown", "Unknown", 1970, 0, 0.0, "No cover");
    }

    public Book(String isbn, String title, String author, String publisher, int year, int pages, double price, String cover) {
        this.isbn = isbn;
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(author);
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.cover = cover;
    }

    public Book(String isbn, String title, ArrayList<String> authors, String publisher, int year, int pages, double price, String cover) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.cover = cover;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthorsList() {
        return authors;
    }

    public String getAuthorsString() {
        if (!authors.isEmpty()) {
            StringJoiner joiner = new StringJoiner(", ","","");
            for (String author : authors)
                joiner.add(author);
            return joiner.toString();
        }
        else
            return "No authors";
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void addAuthors(String... authors) {
        for (String author : authors)
            this.authors.add(author);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(short pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String toString() {
        StringBuilder summaryInfo = new StringBuilder("Summary book info:\n");
        summaryInfo.append("ISBN: ").append(isbn).append(";\n");
        summaryInfo.append("Title: ").append(title).append(";\n");
        summaryInfo.append("Authors: ").append(getAuthorsString()).append("\n");
        summaryInfo.append("Publisher: ").append(publisher).append(";\n");
        summaryInfo.append("Year: ").append(year).append(";\n");
        summaryInfo.append("Pages: ").append(pages).append(";\n");
        summaryInfo.append("Price: $").append(String.format("%.2f",price)).append(";\n");
        summaryInfo.append("Cover: ").append(cover).append(";\n");
        return summaryInfo.toString();
    }
}
