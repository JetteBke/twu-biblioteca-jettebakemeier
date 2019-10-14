package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void shouldHaveCorrectTitle() {
        String testTitle = "Harry Potter";
        Book HarryPotter = new Book(testTitle);
        assertThat(HarryPotter.getTitle(), is(testTitle));
    }
}
