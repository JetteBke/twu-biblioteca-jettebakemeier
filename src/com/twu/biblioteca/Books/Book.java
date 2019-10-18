package com.twu.biblioteca.Books;

import com.twu.biblioteca.User.User;

import java.time.Year;

public class Book {

    private String title;
    private String author;
    private Year year;
    private Boolean checkedOut = false;
    private User checkOutUser = null;

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

    public User getCheckOutUser() { return checkOutUser; }

    public void checkOutBook() { checkedOut = true; }

    public void returnBook() {
        checkedOut = false;
        checkOutUser = null;
    }

    public void setCheckOutUser(User user) { this.checkOutUser = user; }


    @Override
    public String toString() {
        return "Book info - title: " + this.title + ", author: " + this.author + ", year: " + this.year + " checked out: " + this.checkedOut;
    }
}
