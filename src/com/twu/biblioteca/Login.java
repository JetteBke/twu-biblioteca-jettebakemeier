package com.twu.biblioteca;

import com.twu.biblioteca.User.User;

import java.util.List;
import java.util.Scanner;

public class Login {

    private String InputLibraryNumber;
    private String InputPassword;
    private List<User> users = BibliotecaApp.users;

    public void askForCredentials() {
        System.out.println("Please provide your library number below:");
        Scanner scanner = new Scanner(System.in);
        InputLibraryNumber = scanner.nextLine();
        System.out.println("Please provide your password below:");
        InputPassword = scanner.nextLine();
        runLogin();
    }
    public void runLogin() {
        for (User item : users) {
            if (InputLibraryNumber.equals(item.getLibraryNumber()) && InputPassword.equals(item.getPassword())) {
                System.out.println("You successfully logged in");
                break;
            } else if (users.indexOf(item) == (users.size() - 1)){
                System.out.println("Your credentials were not correct");
                askForCredentials();
            }
        }
    }
}