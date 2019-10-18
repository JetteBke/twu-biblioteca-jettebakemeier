package com.twu.biblioteca.User;

import java.util.ArrayList;
import java.util.List;

public class SampleUsers {

    public List<User> Sample() {
        User userOne = new User("234-2375", "no");
        User userTwo = new User("123-1234", "12345678");
        User userThree = new User("111-1111", "123");
        User userFour = new User("222-2222", "111");
        List<User> myUsers = new ArrayList<User>();
        myUsers.add(userOne);
        myUsers.add(userTwo);
        myUsers.add(userThree);
        myUsers.add(userFour);
        return myUsers;
    }
}
