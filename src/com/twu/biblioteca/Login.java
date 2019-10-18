package com.twu.biblioteca;

import com.twu.biblioteca.User.User;

import java.util.List;
import java.util.Scanner;

public class Login {

    private String InputLibraryNumber;
    private String InputPassword;
    public User currentUser;
    private List<User> users = BibliotecaApp.users;
    public Integer tries = 0;

    public void askForCredentials() {
        System.out.println("Please provide your library number below:");
        Scanner scanner = new Scanner(System.in);
        InputLibraryNumber = scanner.nextLine();
        System.out.println("Please provide your password below:");
        InputPassword = scanner.nextLine();
        runLogin();
    }
    public void runLogin() {
        for (User user : users) {
            if (InputLibraryNumber.equals(user.getLibraryNumber()) && InputPassword.equals(user.getPassword())) {
                System.out.println("You successfully logged in");
                currentUser = user;
                break;
            } else if (users.indexOf(user) == (users.size() - 1) && tries < 2){
                System.out.println("Your credentials were not correct");
                tries++;
                askForCredentials();
            }
        }
    }
}