package com.muten.library;

public interface LibraryService {
    void init();
    void regBook();
    void searchBook();
    void borrowBook();
    void returnBook();
    void exit();
}
