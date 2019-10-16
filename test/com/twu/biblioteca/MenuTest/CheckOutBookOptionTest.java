package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Menu.CheckOutBookOption;
import com.twu.biblioteca.Menu.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.BibliotecaApp.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckOutBookOptionTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    //don't know how to extract the checkout variable of the selected book inside the BYTE_ARRAY_OUTPUT_STREAM
    @Test
    public void shouldCheckOutBook() {
        Boolean bookCheckedOut = true;
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutBookOption checkOutOption = new CheckOutBookOption();
        checkOutOption.runAction();
        BYTE_ARRAY_OUTPUT_STREAM.toString();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM, is(bookCheckedOut));
    }

    @Test
    public void shouldNotifySuccessfulCheckOut() {
        String notificationMessage = "You successfully checked out the book!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutBookOption checkOutOption = new CheckOutBookOption();
        checkOutOption.notifySuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }

    @Test
    public void shouldNotifyUnsuccessfulCheckOut() {
        String notificationMessage = "The book you choose does not exist or is not available!\n";
        String data = "4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption();
        checkOutBookOption.notifyUnSuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }
}
