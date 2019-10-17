package com.twu.biblioteca.Books;

import com.twu.biblioteca.Books.Book;

import java.util.ArrayList;

public class BookPrinter {

    public void printBooks(ArrayList<Book> Books) {

        Books.forEach(book ->
            System.out.println(book.toString()));
    }

    public void printAvailableBooks(ArrayList<Book> Books) {

        Books.forEach(book -> { if (book.getCheckedOut() == false) {
            System.out.println(book.toString());
        }
        });
    }

}
