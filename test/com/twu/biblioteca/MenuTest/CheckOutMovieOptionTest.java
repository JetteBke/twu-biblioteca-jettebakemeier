package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Menu.CheckOutBookOption;
import com.twu.biblioteca.Menu.CheckOutMovieOption;
import com.twu.biblioteca.Movies.Movie;
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

    @Test
    public void shouldCheckOutMovie() {
        Movie movie = BibliotecaApp.movies.get(0);

        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        CheckOutMovieOption checkOutOption = new CheckOutMovieOption();
        checkOutOption.runAction();

        assertThat(movie.getCheckedOut(), is(true));
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
