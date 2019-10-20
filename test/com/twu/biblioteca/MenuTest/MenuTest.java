package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.Menu.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldNotifyInvalidOptions() {
        String invalidOption = "Please select a valid option!\n";
        String data = "j";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu();
        menu.runOption();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(invalidOption));
    }
}
