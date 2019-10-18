package com.twu.biblioteca;

import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookPrinter;
import com.twu.biblioteca.Books.SampleBooks;
import com.twu.biblioteca.Menu.*;
import com.twu.biblioteca.Movies.Movie;
import com.twu.biblioteca.Movies.MoviePrinter;
import com.twu.biblioteca.Movies.SampleMovies;
import com.twu.biblioteca.User.SampleUsers;
import com.twu.biblioteca.User.User;

import java.util.List;

public class BibliotecaApp {

    private static SampleBooks sampleBooks = new SampleBooks();
    private static SampleMovies sampleMovies = new SampleMovies();
    private static SampleUsers sampleUsers = new SampleUsers();
    public static List<Book> books = sampleBooks.Sample();
    public static List<Movie> movies = sampleMovies.Sample();
    public static List<User> users = sampleUsers.Sample();


    public static Boolean running = true;

    public static void main(String[] args) {
        WelcomeMessagePrinter welcomeMessagePrinter = new WelcomeMessagePrinter(System.out);
        welcomeMessagePrinter.printWelcomeMessage();
        Login login = new Login();
        login.askForCredentials();
        if (login.tries < 2) {
            User currentUser = login.currentUser;
            Menu menu = new Menu();
            BookPrintOption bookPrintOption = new BookPrintOption(new BookPrinter());
            CheckOutBookOption checkOutBookOption = new CheckOutBookOption(currentUser);
            ReturnBookOption returnBookOption = new ReturnBookOption(currentUser);
            MoviePrintOption moviePrintOption = new MoviePrintOption(new MoviePrinter());
            CheckOutMovieOption checkOutMovieOption = new CheckOutMovieOption();
            ReturnMovieOption returnMovieOption = new ReturnMovieOption();
            QuitAppOption quitAppOption = new QuitAppOption();
            menu.registerMenuOption(bookPrintOption);
            menu.registerMenuOption(checkOutBookOption);
            menu.registerMenuOption(returnBookOption);
            menu.registerMenuOption(moviePrintOption);
            menu.registerMenuOption(checkOutMovieOption);
            menu.registerMenuOption(returnMovieOption);
            menu.registerMenuOption(quitAppOption);
            while (running) {
                menu.printMenu();
                menu.runOption();
            }
        }
        else { System.out.println("You typed in the wrong credentials for too many times...");}
    }
}
