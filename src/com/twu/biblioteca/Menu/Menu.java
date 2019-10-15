package com.twu.biblioteca.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<MenuOption> menuOptions;

    public Menu(){
        this.menuOptions = new ArrayList<>();
    }

    public void registerMenuOption(MenuOption menuOption){
        this.menuOptions.add(menuOption);
    }

    public void printMenu() {
        this.menuOptions.forEach(menuOption -> menuOption.showOption());
    }

    public void runOption() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("1")) {
            this.menuOptions.get(0).runAction();
        } else {
            System.out.println("Please select a valid option!");
        }
    }
}
