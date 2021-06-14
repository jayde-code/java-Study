package com.muten.library;

public class Main {
    public static Boolean run = true;

    public static void main(String[] args) {
        while(run) {
            LibraryServiceImpl libraryService = new LibraryServiceImpl();
            libraryService.init();
        }
    }
}
