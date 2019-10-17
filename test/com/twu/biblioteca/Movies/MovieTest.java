package com.twu.biblioteca.Movies;

import org.junit.Test;

import java.time.Year;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MovieTest {

    @Test
    public void shouldHaveCorrectData() {
        String testTitle = "Verblendung";
        String testDirector = "David Fincher";
        Year testYear = Year.parse("2010");
        String testRating = "unrated";
        Movie testMovie = new Movie(testTitle, testDirector, testYear);
        assertThat(testMovie.getTitle(), is(testTitle));
        assertThat(testMovie.getDirector(), is(testDirector));
        assertThat(testMovie.getYear(), is(testYear));
        assertThat(testMovie.getRating(), is(testRating));
    }
}
