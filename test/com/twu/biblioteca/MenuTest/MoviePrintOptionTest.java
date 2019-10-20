package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.MoviePrintOption;
import com.twu.biblioteca.Movies.Movie;
import com.twu.biblioteca.Movies.MoviePrinter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Year;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MoviePrintOptionTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldDisplayMoviePrintOption() {
        String menuOption = "4. Show all movies\n";
        MoviePrintOption moviePrintOption = new MoviePrintOption(new MoviePrinter());
        Menu menu = new Menu();
        menu.registerMenuOption(moviePrintOption);
        menu.printMenu();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(menuOption));
    }

    @Test
    public void shouldRunMoviePrintOption() {
        String data = "4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        BibliotecaApp.movies.get(0).returnMovie(); // return movie so that it's marked as available, why is it not the same problem for the book print option?
        Movie Verblendung = new Movie("Verblendung", "David Fincher", Year.parse("2010"));
        Movie HarryPotter = new Movie("Harry Potter and the chamber of secrets", "JK Rolling", "2002");
        Movie WhiteChicks = new Movie("White Chicks", "Someone", "2001");
        MoviePrintOption moviePrintOption = new MoviePrintOption(new MoviePrinter());
        Menu menu = new Menu();
        menu.registerMenuOption(moviePrintOption);
        menu.runOption();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(Verblendung.toString()+System.lineSeparator()+HarryPotter.toString()+System.lineSeparator()+WhiteChicks.toString()+System.lineSeparator()));
    }
}
