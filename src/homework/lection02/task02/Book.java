package homework.lection02.task02;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Book {

    private String isbn; //id
    private String title;
    private String authors;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String cover;

    Book()
    {
        isbn = "Unknown";
        title = "Unknown";
        authors = "Unknown";
        publisher = "Unknown";
        year = 1970;
        pages = 1;
        price = 0.0;
        cover = "No info";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn.indexOf("978") == 0 && isbn.length() >= 13)
            this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
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

    public void setYear(int year) {
        if (year >= 0)
            this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages > 0)
            this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price >= 0 ? price : 0;
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
        summaryInfo.append("Authors: ").append(authors).append(";\n");
        summaryInfo.append("Publisher: ").append(publisher).append(";\n");
        summaryInfo.append("Year: ").append(year).append(";\n");
        summaryInfo.append("Pages: ").append(pages).append(";\n");
        summaryInfo.append("Price: $").append(String.format("%.2f",price)).append(";\n");
        summaryInfo.append("Cover: ").append(cover).append(";\n");
        return summaryInfo.toString();
    }
}
