package com.twu.biblioteca;

import java.io.PrintStream;

public class WelcomeMessagePrinter {

    private final PrintStream printStream;

    public WelcomeMessagePrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
