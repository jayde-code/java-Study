package com.muten.library;

public interface LibraryService {
    void init();
    void regBook();
    void searchBook() throws Exception;
    void borrowBook();
    void returnBook() throws Exception;
    void exit();
}
