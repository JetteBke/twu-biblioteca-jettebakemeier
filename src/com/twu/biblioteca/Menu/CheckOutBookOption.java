package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookPrinter;
import com.twu.biblioteca.SampleBooks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class CheckOutBookOption implements MenuOption {

    @Override
    public void showOption() {
        System.out.println("3. Check out a book");
    }
    List<Book> books = BibliotecaApp.books;

    @Override
    public void runAction() {
        BookPrinter bookPrinter = new BookPrinter();
        bookPrinter.printBooks((ArrayList<Book>) books);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int index = parseInt(s) - 1;
        Book selectedBook = books.get(index);
        selectedBook.setCheckedOut();
        books.set(index, selectedBook);
    }
}
