package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Movies.Movie;

import java.util.List;
import java.util.Scanner;

public class ReturnMovieOption implements MenuOption {

    @Override
    public void showOption() {
        System.out.println("6. Return a movie");
    }

    private List<Movie> movies = BibliotecaApp.movies;

    @Override
    public void runAction() {
        System.out.println("Please provide the title of the movie to return it");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println("Searching for provided title: " + userInput);
        for (Movie movie : movies) {
            if (movies.size() - 1 == movies.indexOf(movie)) {
                notifyUnSuccess();
            } else if (movie.getTitle().equals(userInput)) {
                movie.returnMovie();
                notifySuccess();
                break;
            }
        }
    }

    // public because of testing
    public void notifySuccess() {
        System.out.println("You successfully returned the movie!");
    }

    public void notifyUnSuccess() {
        System.out.println("This is not a valid movie to return!");
    }
}
