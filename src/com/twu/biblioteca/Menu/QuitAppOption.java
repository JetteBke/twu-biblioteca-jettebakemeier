package com.twu.biblioteca.Menu;

import com.twu.biblioteca.BibliotecaApp;

public class QuitAppOption implements MenuOption {


    @Override
    public boolean thisInputIsForMe(String s) {
        if(s.equals("8")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void showOption() {
        System.out.println("8. Quit Application");
    }

    @Override
    public void runAction() {
        System.out.println("You are leaving the app... See you soon!");
        BibliotecaApp.running = false;
    }
}
