package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.Menu.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    private static final ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();

    @Before
    public void setOutputStream() {
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldDisplayBookPrintOption() {
        String menuOption = "1. Show all books\n";
        Menu menu = new Menu();
        menu.showBookPrintOption();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(menuOption));
    }
}
