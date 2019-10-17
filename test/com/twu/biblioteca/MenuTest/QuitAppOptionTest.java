package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.QuitAppOption;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuitAppOptionTest {

    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldQuitApplication() {
        String goodbyeMessage = "You are leaving the app... See you soon!\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu();
        QuitAppOption quitAppOption = new QuitAppOption();
        menu.registerMenuOption(quitAppOption);
        menu.runOption();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(goodbyeMessage));
    }
}
