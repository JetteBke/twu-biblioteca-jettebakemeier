package com.twu.biblioteca.Movies;

import java.util.ArrayList;
import java.util.List;

public class SampleMovies {

    public List<Movie> Sample() {

        Movie Verblendung = new Movie("Verblendung", "David Fincher", "2010");
        Movie HarryPotter = new Movie("Harry Potter and the chamber of secrets", "JK Rolling", "2002");
        Movie WhiteChicks = new Movie("White Chicks", "Someone", "2001");
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(Verblendung);
        movies.add(HarryPotter);
        movies.add(WhiteChicks);
        return movies;
    }
}
