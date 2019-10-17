package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookPrinter;
import com.twu.biblioteca.Menu.BookPrintOption;
import com.twu.biblioteca.Menu.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookPrintOptionTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldDisplayBookPrintOption() {
        String menuOption = "1. Show all books\n";
        BookPrintOption bookPrintOption = new BookPrintOption(new BookPrinter());
        Menu menu = new Menu();
        menu.registerMenuOption(bookPrintOption);
        menu.printMenu();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(menuOption));
    }

    @Test
    public void shouldRunBookPrintOption() {
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BookPrintOption bookPrintOption = new BookPrintOption(new BookPrinter());
        Menu menu = new Menu();
        menu.registerMenuOption(bookPrintOption);
        menu.runOption();
        Book HarryPotter = new Book("Harry Potter", "JK Rolling", "1998");
        Book HarryPotter2 = new Book("Harry Potter and the chamber of secrets", "JK Rolling", "2002");
        Book HarryPotter3 = new Book("Harry Potter and the prisoner of ascaban", "JK Rolling", "2005");
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(HarryPotter.toString()+System.lineSeparator()+HarryPotter2.toString()+System.lineSeparator()+HarryPotter3.toString()+System.lineSeparator()));
    }
}
