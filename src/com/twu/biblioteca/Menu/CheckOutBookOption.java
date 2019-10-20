package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookPrinter;
import com.twu.biblioteca.User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class CheckOutBookOption implements MenuOption {

    private User currentUser;

    public CheckOutBookOption(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public boolean thisInputIsForMe(String s) {
        if(s.equals("2")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void showOption() {
        System.out.println("2. Check out a book");
    }

    @Override
    public void runAction() {
        System.out.println("Choose the number of a book to check it out");
        List<Book> books = BibliotecaApp.books;
        BookPrinter bookPrinter = new BookPrinter();
        bookPrinter.printBooks((ArrayList<Book>) books);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int index = parseInt(s) - 1;
        if (index < 2) {
            Book selectedBook = books.get(index);
            if(selectedBook.getCheckedOut()) {
                selectedBook.checkOutBook();
                selectedBook.setCheckOutUser(currentUser);
                books.set(index, selectedBook);
                notifySuccess();
            } else {
                notifyUnSuccess();
            }
        } else { notifyUnSuccess();
        }
    }

    // public because of testing
    public void notifySuccess() {
        System.out.println("You successfully checked out the book!");
    }

    public void notifyUnSuccess() {
        System.out.println("The book you choose does not exist or is not available!");
    }
}
