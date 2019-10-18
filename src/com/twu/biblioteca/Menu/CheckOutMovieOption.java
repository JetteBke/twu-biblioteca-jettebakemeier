package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Movies.Movie;
import com.twu.biblioteca.Movies.MoviePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CheckOutMovieOption implements MenuOption {


    @Override
    public void showOption() {
        System.out.println("5. Check out a movie");
    }

    @Override
    public void runAction() {
        System.out.println("Choose the number of a movie to check it out");
        List<Movie> movies = BibliotecaApp.movies;
        MoviePrinter moviePrinter = new MoviePrinter();
        moviePrinter.printMovies((ArrayList<Movie>) movies);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int index = parseInt(s) - 1;
        Movie selectedMovie = movies.get(index);
        if(selectedMovie.getCheckedOut()) {
            notifyUnSuccess();
        } else {
            selectedMovie.checkOutMovie();
            movies.set(index, selectedMovie);
            notifySuccess();
        }
    }

    // public because of testing
    public void notifySuccess() {
        System.out.println("You successfully checked out the movie!");
    }

    public void notifyUnSuccess() {
        System.out.println("The movie you choose does not exist or is not available!");
    }
}
