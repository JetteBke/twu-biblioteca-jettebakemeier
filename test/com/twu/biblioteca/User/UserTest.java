package com.twu.biblioteca.User;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void shouldHaveLoginData() {
        String testLibraryNumber = "123-1234";
        String testPassword = "12345678";
        User testUser = new User(testLibraryNumber, testPassword);
        assertThat(testUser.getLibraryNumber(), is(testLibraryNumber));
        assertThat(testUser.getPassword(), is(testPassword));
    }
}
