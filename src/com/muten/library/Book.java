package com.muten.library;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Book {
    private static int indexNo = 1;
    private final int bookId;
    private final String bookTitle;
    private final String author;
    private String borrowDate;
    private String returnDate;
    private int status;


    public Book(String bookTitle, String author) {
        this.bookId = indexNo;
        this.bookTitle = bookTitle;
        this.author = author;
        this.status = 0;
        indexNo++;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
