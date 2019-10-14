package com.twu.biblioteca;

import com.twu.biblioteca.Menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter();
        welcomeMessagePrinter.printWelcomeMessage();
        Menu menu = new Menu();
        menu.showBookPrintOption();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s.equals("1")) {
            menu.selectBookPrintOption();
        }
    }
}
