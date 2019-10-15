package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookPrinter;

import java.util.ArrayList;
import java.util.List;

public class BookPrintOption implements MenuOption {

    private final BookPrinter bookPrinter;

    public BookPrintOption(BookPrinter bookPrinter) {
        this.bookPrinter = bookPrinter;
    }

    @Override
    public void showOption() {
        System.out.println("1. Show all books");
    }

    @Override
    public void runAction() {
        Book HarryPotter = new Book("Harry Potter", "JK Rolling", "1998");
        Book HarryPotter2 = new Book("Harry Potter and the chamber of secrets", "JK Rolling", "2002");
        Book HarryPotter3 = new Book("Harry Potter and the prisoner of ascaban", "JK Rolling", "2005");
        List<Book> books = new ArrayList<Book>();
        books.add(HarryPotter);
        books.add(HarryPotter2);
        books.add(HarryPotter3);
        bookPrinter.printBooks(books);
    }
}
