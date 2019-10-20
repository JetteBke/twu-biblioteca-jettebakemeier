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
        boolean somethingWasRun = false;
        for (MenuOption menuOption: menuOptions) {
            if (menuOption.thisInputIsForMe(s)) {
                menuOption.runAction();
                somethingWasRun = true;
            }
        }

        if (!somethingWasRun) {
            System.out.println("Please select a valid option!");
        }
    }
}
