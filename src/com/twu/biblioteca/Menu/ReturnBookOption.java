package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.User.User;

import java.util.List;
import java.util.Scanner;

public class ReturnBookOption implements MenuOption {

    private User currentUser;

    public ReturnBookOption(User currentUser) {
        currentUser = currentUser;
    }

    @Override
    public void showOption() {

        System.out.println("3. Return a book");
    }

    private List<Book> books = BibliotecaApp.books;

    @Override
    public void runAction() {
        //prompt user for input
        System.out.println("Whats the title of the book you want to return?");
        Scanner scanner = new Scanner(System.in);
        //save input
        String userInput = scanner.nextLine();
        System.out.println("Searching for provided title: " + userInput);
        //iterate through books
        for (Book book : books) {//find book by user input
            if (books.size() - 1 == books.indexOf(book)) {
                notifyUnSuccess();
            } else if (book.getTitle().equals(userInput) && (book.getCheckOutUser() == currentUser)) {
                book.returnBook();
                notifySuccess();
                break;
            }
        }
    }

    // public because of testing
    public void notifySuccess() {
        System.out.println("You successfully returned the book!");
    }

    public void notifyUnSuccess() {
        System.out.println("This is not a valid book to return!");
    }
}
