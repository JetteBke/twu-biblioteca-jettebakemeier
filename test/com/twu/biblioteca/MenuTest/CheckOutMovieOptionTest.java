package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.Menu.CheckOutBookOption;
import com.twu.biblioteca.Menu.CheckOutMovieOption;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckOutMovieOptionTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldShowOption() {

    }

    //don't know how to extract the checkout variable of the selected movie inside the BYTE_ARRAY_OUTPUT_STREAM
    @Test
    public void shouldCheckOutMovie() {
        Boolean movieCheckedOut = true;
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutMovieOption checkOutOption = new CheckOutMovieOption();
        checkOutOption.runAction();
        BYTE_ARRAY_OUTPUT_STREAM.toString();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM, is(movieCheckedOut));
    }

    @Test
    public void shouldNotifySuccessfulCheckOut() {
        String notificationMessage = "You successfully checked out the movie!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutMovieOption checkOutOption = new CheckOutMovieOption();
        checkOutOption.notifySuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }

    @Test
    public void shouldNotifyUnsuccessfulCheckOut() {
        String notificationMessage = "The movie you choose does not exist or is not available!\n";
        String data = "4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutMovieOption checkOutOption = new CheckOutMovieOption();
        checkOutOption.notifyUnSuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }
}
