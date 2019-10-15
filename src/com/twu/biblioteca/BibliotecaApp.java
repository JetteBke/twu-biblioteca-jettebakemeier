package com.twu.biblioteca;

import com.twu.biblioteca.Menu.BookPrintOption;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.QuitAppOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static Boolean running = true;

    public static void main(String[] args) {
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter();
        welcomeMessagePrinter.printWelcomeMessage();
        while (running) {
            Menu menu = new Menu();
            BookPrintOption bookPrintOption = new BookPrintOption();
            QuitAppOption quitAppOption = new QuitAppOption();
            menu.registerMenuOption(bookPrintOption);
            menu.registerMenuOption(quitAppOption);
            menu.printMenu();
            menu.runOption();
        }
    }
}
