package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class SampleBooks {

    public List<Book> Sample() {
        Book HarryPotter = new Book("Harry Potter", "JK Rolling", "1998");
        Book HarryPotter2 = new Book("Harry Potter and the chamber of secrets", "JK Rolling", "2002");
        Book HarryPotter3 = new Book("Harry Potter and the prisoner of ascaban", "JK Rolling", "2005");
        List<Book> books = new ArrayList<Book>();
        books.add(HarryPotter);
        books.add(HarryPotter2);
        books.add(HarryPotter3);
        return books;
    }
}
