package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookPrinter;

import java.util.ArrayList;
import java.util.List;

public class BookPrintOption implements MenuOption {

    private final BookPrinter bookPrinter;
    List<Book> books = BibliotecaApp.books;

    public BookPrintOption(BookPrinter bookPrinter) {
        this.bookPrinter = bookPrinter;
    }

    @Override
    public void showOption() {
        System.out.println("1. Show all books");
    }

    @Override
    public void runAction() {
        bookPrinter.printAvailableBooks((ArrayList<Book>) books);
    }
}
