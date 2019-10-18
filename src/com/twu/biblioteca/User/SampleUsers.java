package com.twu.biblioteca.User;

import java.util.ArrayList;
import java.util.List;

public class SampleUsers {

    public List<User> Sample() {
        User userOne = new User("222-2222", "111", "Kevin", "kevin@abc.com", 012345);
        User userTwo = new User("123-1234", "12345678", "Adina", "adina@gmail.com", 22222);
        List<User> myUsers = new ArrayList<User>();
        myUsers.add(userOne);
        myUsers.add(userTwo);
        return myUsers;
    }
}
