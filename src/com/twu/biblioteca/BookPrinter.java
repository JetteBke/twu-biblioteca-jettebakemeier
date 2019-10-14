package com.twu.biblioteca;

import java.util.List;

public class BookPrinter {

    public void printBooks(List<Book> Books) {
        Books.forEach(book -> System.out.println(book.toString()));
    }

}
