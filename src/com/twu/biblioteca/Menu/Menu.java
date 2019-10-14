package com.twu.biblioteca.Menu;

public class Menu {

    public void showBookPrintOption() {
        BookPrintOption bookPrintOption = new BookPrintOption();
        bookPrintOption.showOption();
    }

    public void selectBookPrintOption() {
        BookPrintOption bookPrintOption = new BookPrintOption();
        bookPrintOption.runAction();
    }
}
