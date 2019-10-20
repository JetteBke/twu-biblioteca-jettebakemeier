package com.twu.biblioteca.MenuTest;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.ViewInfoOption;

import com.twu.biblioteca.User.User;
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
        User user = BibliotecaApp.users.get(0);
        String userInfo = "name: " + user.getName() + "\nemail: " + user.getEmail() + "\nphone number: " + user.getPhoneNumber() + "\n";
        String data = "7";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ViewInfoOption viewInfoOption = new ViewInfoOption(user);
        Menu menu = new Menu();
        menu.registerMenuOption(viewInfoOption);
        menu.runOption();
        assertThat(BYTE_ARRAY_OUTPUT_STREAM.toString(), is(userInfo));
    }
}
