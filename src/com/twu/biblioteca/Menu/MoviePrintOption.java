package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Movies.Movie;
import com.twu.biblioteca.Movies.MoviePrinter;

import java.util.ArrayList;
import java.util.List;

public class MoviePrintOption implements MenuOption {

    private final MoviePrinter moviePrinter;
    List<Movie> movies = BibliotecaApp.movies;


    public MoviePrintOption(MoviePrinter moviePrinter) {
        this.moviePrinter = moviePrinter;
    }

    @Override
    public void showOption() {
        System.out.println("4. Show all movies");
    }

    @Override
    public void runAction() {
        moviePrinter.printAvailableMovies((ArrayList<Movie>) movies);
    }
}
