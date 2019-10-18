package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Menu.CheckOutBookOption;
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

    //don't know how to extract the checkout variable of the selected book inside the BYTE_ARRAY_OUTPUT_STREAM
    @Test
    public void shouldReturnBook() {
        Boolean bookCheckedOut = false;
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnBookOption returnBookOption = new ReturnBookOption(BibliotecaApp.users.get(0));
        returnBookOption.runAction();
        BYTE_ARRAY_OUTPUT_STREAM.toString();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM, is(bookCheckedOut));
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
