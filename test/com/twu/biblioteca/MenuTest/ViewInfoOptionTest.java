package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.ViewInfoOption;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ViewInfoOptionTest {
    private ByteArrayOutputStream BYTE_ARRAY_OUTPUT_STREAM;

    @Before
    public void setOutputStream() {
        BYTE_ARRAY_OUTPUT_STREAM = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BYTE_ARRAY_OUTPUT_STREAM));
    }

    @Test
    public void shouldShowViewInfoOption() {
        String menuOption = "7. See personal information\n";
        ViewInfoOption viewInfoOption = new ViewInfoOption(BibliotecaApp.users.get(0));
        Menu menu = new Menu();
        menu.registerMenuOption(viewInfoOption);
        menu.printMenu();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(menuOption));
    }

    @Test
    public void shouldRunViewInfoOption() {
        String userInfo = "name: " + BibliotecaApp.users.get(0).getName() + "\nemail: " + BibliotecaApp.users.get(0).getEmail() + "\nphone number: " + BibliotecaApp.users.get(0).getPhoneNumber() + "\n";
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ViewInfoOption viewInfoOption = new ViewInfoOption(BibliotecaApp.users.get(0));
        Menu menu = new Menu();
        menu.registerMenuOption(viewInfoOption);
        menu.runOption();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(userInfo));
    }
}
