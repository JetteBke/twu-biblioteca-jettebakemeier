package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WelcomeMessagePrinterTest {

    private static final ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldPrintWelcomeMessage() {

        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter(System.out);
        welcomeMessagePrinter.printWelcomeMessage();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(welcomeMessage));
    }
}
