package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter();
        welcomeMessagePrinter.printWelcomeMessage();
        Book HarryPotter = new Book("Harry Potter");
        Book HarryPotter2 = new Book("Harry Potter and the chamber of secrets");
        Book HarryPotter3 = new Book("Harry Potter and the prisoner of ascaban");
        List<Book> books = new ArrayList<Book>();
        books.add(HarryPotter);
        books.add(HarryPotter2);
        books.add(HarryPotter3);
        BookPrinter printer = new BookPrinter();
        printer.printBooks(books);
    }
}
