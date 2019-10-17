package com.twu.biblioteca.Movies;

import java.util.ArrayList;

public class MoviePrinter {

    public void printMovies(ArrayList<Movie> Movies) {

        Movies.forEach((Movie) -> System.out.println(Movie.toString()));
    }

    public void printAvailableMovies(ArrayList<Movie> Movies) {

        Movies.forEach(movie -> { if (movie.getCheckedOut() == false) {
            System.out.println(movie.toString());
        }
        });
    }
}
