package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.ReturnBookOption;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReturnBookOptionTest {
    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldDisplayOption() {
        String menuOption = "3. Return a book\n";
        ReturnBookOption returnBookOption = new ReturnBookOption(BibliotecaApp.users.get(0));
        Menu menu = new Menu();
        menu.registerMenuOption(returnBookOption);
        menu.printMenu();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(menuOption));
    }

    @Test
    public void shouldReturnBook() {
        Book book = BibliotecaApp.books.get(0);
        book.checkOutBook();

        String data = "Harry Potter";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnBookOption returnBookOption = new ReturnBookOption(BibliotecaApp.users.get(0));
        returnBookOption.runAction();

        assertThat(book.getCheckedOut(), is(false));
    }

    @Test
    public void shouldNotifySuccessfulReturn() {
        String notificationMessage = "You successfully returned the book!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnBookOption returnBookOption = new ReturnBookOption(BibliotecaApp.users.get(0));
        returnBookOption.notifySuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }

    @Test
    public void shouldNotifyUnsuccessfulReturn() {
        String notificationMessage = "This is not a valid book to return!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnBookOption returnBookOption = new ReturnBookOption(BibliotecaApp.users.get(0));
        returnBookOption.notifyUnSuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }
}
