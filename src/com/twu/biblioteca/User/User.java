package com.twu.biblioteca.User;

public class User {

    private static String libraryNumber;
    private static String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public static String getLibraryNumber() {
        return libraryNumber;
    }

    public static String getPassword() {
        return password;
    }
}
