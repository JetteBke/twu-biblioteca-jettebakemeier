package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.User.User;

public class ViewInfoOption implements MenuOption {

    private User currentUser;

    public ViewInfoOption(User user) {
        currentUser = user;
    }

    @Override
    public void showOption() {
        System.out.println("7. See personal information");
    }

    @Override
    public void runAction() {
        String userInfo = "name: " + currentUser.getName() + "\nemail: " + currentUser.getEmail() + "\nphone number: " + currentUser.getPhoneNumber();
        System.out.println(userInfo);
    }
}
