package com.twu.biblioteca.Menu;

public interface MenuOption {

    public boolean thisInputIsForMe(String s);

    public default void showOption() {

    }

    public void runAction();
}
