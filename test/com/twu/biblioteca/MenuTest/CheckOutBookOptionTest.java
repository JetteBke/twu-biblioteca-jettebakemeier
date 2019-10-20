package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Menu.CheckOutBookOption;
import com.twu.biblioteca.Menu.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckOutBookOptionTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    //testing interface
    @Test
    public void shouldDisplayOption() {
        String menuOption = "2. Check out a book\n";
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption(BibliotecaApp.users.get(0));
        Menu menu = new Menu();
        menu.registerMenuOption(checkOutBookOption);
        menu.printMenu();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(menuOption));
    }

    //testing logic
    @Test
    public void shouldCheckOutBook() {
        Book book = BibliotecaApp.books.get(0);

        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutBookOption checkOutOption = new CheckOutBookOption(BibliotecaApp.users.get(0));
        checkOutOption.runAction();

        assertThat(book.getCheckedOut(), is(true));
    }

    @Test
    public void shouldNotifySuccessfulCheckOut() {
        String notificationMessage = "You successfully checked out the book!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutBookOption checkOutOption = new CheckOutBookOption(BibliotecaApp.users.get(0));
        checkOutOption.notifySuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }

    @Test
    public void shouldNotifyUnsuccessfulCheckOut() {
        String notificationMessage = "The book you choose does not exist or is not available!\n";
        String data = "4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption(BibliotecaApp.users.get(0));
        checkOutBookOption.notifyUnSuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }
}
