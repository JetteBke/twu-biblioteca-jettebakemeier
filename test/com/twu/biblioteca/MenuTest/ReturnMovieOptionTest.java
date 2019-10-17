package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.ReturnMovieOption;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReturnMovieOptionTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldDisplayOption() {
        String menuOption = "6. Return a movie\n";
        ReturnMovieOption returnMovieOption = new ReturnMovieOption();
        Menu menu = new Menu();
        menu.registerMenuOption(returnMovieOption);
        menu.printMenu();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(menuOption));
    }

    @Test
    public void shouldReturnMovie() {
        Boolean movieCheckedOut = false;
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnMovieOption returnMovieOption = new ReturnMovieOption();
        returnMovieOption.runAction();
        BYTE_ARRAY_OUTPUT_STREAM.toString();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM, is(movieCheckedOut));
    }

    @Test
    public void shouldNotifySuccessfulReturn() {
        String notificationMessage = "You successfully returned the movie!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnMovieOption returnMovieOption = new ReturnMovieOption();
        returnMovieOption.notifySuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }

    @Test
    public void shouldNotifyUnsuccessfulReturn() {
        String notificationMessage = "This is not a valid movie to return!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ReturnMovieOption returnMovieOption = new ReturnMovieOption();
        returnMovieOption.notifyUnsuccess();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(notificationMessage));
    }
}
