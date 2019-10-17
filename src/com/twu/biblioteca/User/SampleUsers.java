package com.twu.biblioteca.User;

import com.twu.biblioteca.Books.Book;

import java.util.ArrayList;
import java.util.List;

public class SampleUsers {

    public List<User> Sample() {
        User userOne = new User("234-2375", "no");
        User userTwo = new User("123-1234", "12345678");
        List<User> myUsers = new ArrayList<User>();
        myUsers.add(userOne);
        myUsers.add(userTwo);
        return myUsers;
    }
}
