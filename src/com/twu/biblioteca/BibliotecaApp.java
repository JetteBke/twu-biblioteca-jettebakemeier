package com.twu.biblioteca;

import com.twu.biblioteca.Menu.BookPrintOption;
import com.twu.biblioteca.Menu.CheckOutBookOption;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.QuitAppOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        menu.registerMenuOption(bookPrintOption);
        menu.registerMenuOption(checkOutBookOption);
        menu.registerMenuOption(quitAppOption);
        while (running) {
            menu.printMenu();
            menu.runOption();
        }
    }
}
