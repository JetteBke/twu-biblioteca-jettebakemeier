package com.twu.biblioteca;

import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookPrinter;
import com.twu.biblioteca.Books.SampleBooks;
import com.twu.biblioteca.Menu.*;
import com.twu.biblioteca.Movies.Movie;
import com.twu.biblioteca.Movies.MoviePrinter;
import com.twu.biblioteca.Movies.SampleMovies;

import java.util.List;

public class BibliotecaApp {

    private static SampleBooks sampleBooks = new SampleBooks();
    private static SampleMovies sampleMovies = new SampleMovies();
    public static List<Book> books = sampleBooks.Sample();
    public static List<Movie> movies = sampleMovies.Sample();

    public static Boolean running = true;

    public static void main(String[] args) {
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter(System.out);
        welcomeMessagePrinter.printWelcomeMessage();
        Menu menu = new Menu();
        BookPrintOption bookPrintOption = new BookPrintOption(new BookPrinter());
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption();
        ReturnBookOption returnBookOption = new ReturnBookOption();
        MoviePrintOption moviePrintOption = new MoviePrintOption(new MoviePrinter());
        CheckOutMovieOption checkOutMovieOption = new CheckOutMovieOption();
        QuitAppOption quitAppOption = new QuitAppOption();
        menu.registerMenuOption(bookPrintOption);
        menu.registerMenuOption(checkOutBookOption);
        menu.registerMenuOption(returnBookOption);
        menu.registerMenuOption(moviePrintOption);
        menu.registerMenuOption(checkOutMovieOption);
        menu.registerMenuOption(quitAppOption);
        while (running) {
            menu.printMenu();
            menu.runOption();
        }
    }
}
