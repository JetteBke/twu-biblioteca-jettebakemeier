package com.twu.biblioteca.Movies;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoviePrinterTest {

    private static final ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldPrintAllMovies() {
        Movie Verblendung = new Movie("Verblendung", "David Fincher",Year.parse("2010"));
        Movie HarryPotter = new Movie("Harry Potter and the chamber of secrets", "JK Rolling", "2002");
        Movie WhiteChicks = new Movie("White Chicks", "Someone", "2001");
        MoviePrinter moviePrinter = new MoviePrinter();
        SampleMovies sampleMovies = new SampleMovies();
        List<Movie> movies = sampleMovies.Sample();
        moviePrinter.printMovies((ArrayList<Movie>) movies);
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(Verblendung.toString()+System.lineSeparator()+HarryPotter.toString()+System.lineSeparator()+WhiteChicks.toString()+System.lineSeparator()));
    }
}
