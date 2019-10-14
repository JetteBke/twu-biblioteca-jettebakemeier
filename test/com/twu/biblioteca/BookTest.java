package com.twu.biblioteca;

import org.junit.Test;

import java.time.Year;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void shouldHaveCorrectData() {
        String testTitle = "Harry Potter";
        String testAuthor = "JK Rowling";
        Year testYear = Year.parse("1998");
        Book HarryPotter = new Book(testTitle, testAuthor, testYear);
        assertThat(HarryPotter.getTitle(), is(testTitle));
        assertThat(HarryPotter.getAuthor(), is(testAuthor));
        assertThat(HarryPotter.getYear(), is(testYear));
    }
}
