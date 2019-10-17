package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Books.Book;
import com.twu.biblioteca.Books.BookPrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class CheckOutBookOption implements MenuOption {

    @Override
    public void showOption() {
        System.out.println("2. Check out a book");
    }
    private List<Book> books = BibliotecaApp.books;

    @Override
    public void runAction() {
        BookPrinter bookPrinter = new BookPrinter();
        bookPrinter.printBooks((ArrayList<Book>) books);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int index = parseInt(s) - 1;
        Book selectedBook = books.get(index);
        if(selectedBook.getCheckedOut()) {
            notifyUnSuccess();
        } else {
            selectedBook.setCheckedOut();
            books.set(index, selectedBook);
            notifySuccess();
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
