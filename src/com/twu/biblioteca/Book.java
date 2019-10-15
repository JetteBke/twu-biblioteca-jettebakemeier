package com.twu.biblioteca;

import java.time.Year;

public class Book {

    private String title;
    private String author;
    private Year year;
    private Boolean checkedOut = false;

    public Book(String title, String author, Year year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(String title, String author, String year) {
        this(title,author,Year.parse(year));
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Year getYear() {
        return year;
    }

    public Boolean getCheckedOut() { return checkedOut; }

    public void setCheckedOut() { checkedOut = !checkedOut; }

    @Override
    public String toString() {
        return "Book info - title: " + this.title + ", author: " + this.author + ", year: " + this.year + " checked out: " + this.checkedOut;
    }
}
