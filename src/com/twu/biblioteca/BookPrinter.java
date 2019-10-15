package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookPrinter {

    public void printBooks(ArrayList<Book> Books) {

        Books.forEach(book -> { if (book.getCheckedOut() == false) {
            System.out.println(book.toString());
            }
        });
    }

}
