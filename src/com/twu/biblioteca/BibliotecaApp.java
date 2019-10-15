package com.twu.biblioteca;

import com.twu.biblioteca.Menu.BookPrintOption;
import com.twu.biblioteca.Menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter();
        welcomeMessagePrinter.printWelcomeMessage();
        Menu menu = new Menu();
        BookPrintOption bookPrintOption = new BookPrintOption();
        menu.registerMenuOption(bookPrintOption);
        menu.printMenu();
        menu.runOption();
    }
}
