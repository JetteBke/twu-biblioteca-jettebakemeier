package com.twu.biblioteca;

import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookPrinter;
import com.twu.biblioteca.Books.SampleBooks;
import com.twu.biblioteca.Menu.*;

import java.util.List;

public class BibliotecaApp {

    private static SampleBooks sampleBooks = new SampleBooks();
    public static List<Book> books = sampleBooks.Sample();

    public static Boolean running = true;

    public static void main(String[] args) {
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter(System.out);
        welcomeMessagePrinter.printWelcomeMessage();
        Menu menu = new Menu();
        BookPrintOption bookPrintOption = new BookPrintOption(new BookPrinter());
        QuitAppOption quitAppOption = new QuitAppOption();
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption();
        ReturnBookOption returnBookOption = new ReturnBookOption();
        menu.registerMenuOption(bookPrintOption);
        menu.registerMenuOption(checkOutBookOption);
        menu.registerMenuOption(returnBookOption);
        menu.registerMenuOption(quitAppOption);
        while (running) {
            menu.printMenu();
            menu.runOption();
        }
    }
}
