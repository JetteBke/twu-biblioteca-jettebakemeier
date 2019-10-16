package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookPrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class CheckOutBookOption implements MenuOption {

    @Override
    public void showOption() {
        System.out.println("3. Check out a book");
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
        selectedBook.setCheckedOut();
        books.set(index, selectedBook);
        notifySuccess();
    }

    public void notifySuccess() {
        System.out.println("You successfully checked out the book!");
    }
}
