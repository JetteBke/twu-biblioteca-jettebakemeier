package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookPrinterTest {

    private static final ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldPrintBooks() {
        Book HarryPotter = new Book("Harry Potter", "JK Rolling", "1998");
        Book HarryPotter2 = new Book("Harry Potter and the chamber of secrets", "JK Rolling", "2002");
        Book HarryPotter3 = new Book("Harry Potter and the prisoner of ascaban", "JK Rolling", "2005");
        BookPrinter bookPrinter = new BookPrinter();
        SampleBooks sampleBooks = new SampleBooks();
        List<Book> books = sampleBooks.Sample();
        bookPrinter.printBooks((ArrayList<Book>) books);
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(HarryPotter.toString()+System.lineSeparator()+HarryPotter2.toString()+System.lineSeparator()+HarryPotter3.toString()+System.lineSeparator()));
    }
}
