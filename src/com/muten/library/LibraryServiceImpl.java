package com.muten.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryServiceImpl implements LibraryService {

    private static final Date date = new Date();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
    private static final String today = sdf.format(date);
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<Integer, Book> bookList = new HashMap<Integer, Book>();

    @Override
    public void init() {
        try {
            System.out.print(
                    "********** MUTEN LIBRARY **********\n" +
                            "[1] Book Register\n" +
                            "[2] Book Search\n" +
                            "[3] Book Borrow\n" +
                            "[4] Book Return\n" +
                            "[0] EXIT\n" +
                            ">> ");
            String menu = sc.next();

            switch (menu) {
                case "1":
                    regBook();
                    break;
                case "2":
                    searchBook();
                    break;
                case "3":
                    borrowBook();
                    break;
                case "4":
                    returnBook();
                    break;
                case "0":
                    exit();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println(">>>>> bookId는 숫자로만 입력 가능합니다. <<<<<");
        } catch (NullPointerException e) {
            System.out.println(">>>>>>>> 잘못된 입력을 감지했습니다. <<<<<<<<");
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>> 해당되는 목록이 없습니다. <<<<<<<<<<<");
        }
    }

    @Override
    public void regBook() {
        System.out.print("Book Title >> ");
        String bt = sc.next();
        System.out.print("Book Author >> ");
        String at = sc.next();
        Book book = new Book(bt, at);
        bookList.put(book.getBookId(), book);
    }

    @Override
    public void searchBook() throws Exception {
        boolean anyBook = false;
        for (Integer key : bookList.keySet()) {
            System.out.println(bookList.get(key));
            anyBook = true;
        }
        if (!anyBook) {
            throw new Exception();
        }
    }

    @Override
    public void borrowBook() throws InputMismatchException, NullPointerException {
        boolean isCheck = false;
        System.out.println("***** 대여 가능한 도서 목록 *****");
        for (Integer key : bookList.keySet()) {
            if (bookList.get(key).getStatus() == 0) {
                System.out.println(bookList.get(key));
            }
        }
        System.out.print("대여할 책의 bookId를 입력하세요.\n>> ");
        int bb = sc.nextInt();
        if (bookList.get(bb).getStatus() == 0) {
            bookList.get(bb).setBorrowDate(today);
            bookList.get(bb).setReturnDate(null);
            bookList.get(bb).setStatus(1);
            System.out.println(bookList.get(bb) + "가 대여되었습니다.");
            isCheck = true;
        } else if (bookList.get(bb).getStatus() == 1) {
            System.out.println("이미 대여중인 도서입니다.");
            isCheck = true;
        }
        if (!isCheck) {
            System.out.println("존재하지 않는 bookId 입니다.");
        }
    }

    @Override
    public void returnBook() throws InputMismatchException, Exception {
        boolean anyBorrow = false;

        System.out.println("***** 대여중인 도서 목록 *****");
        for (Integer key : bookList.keySet()) {
            if (bookList.get(key).getBorrowDate() != null) {
                System.out.println(bookList.get(key));
                anyBorrow = true;
            }
        }

        if (anyBorrow) {
            System.out.print("반납할 도서 bookId를 입력해주세요.\n>> ");
            int rb = sc.nextInt();
            if (bookList.get(rb).getBorrowDate() != null && bookList.get(rb).getReturnDate() == null) {
                try {
                    System.out.print("반납일을 입력해주세요. (ex: 20210615) >> ");
                    String rd = sc.next();
                    Date rrdd = sdf.parse(rd);
                    Date bbdd = sdf.parse(bookList.get(rb).getBorrowDate());
                    long calDate = rrdd.getTime() - bbdd.getTime();
                    long borrowDays = calDate / (24 * 60 * 60 * 1000);
                    if (borrowDays > 3) {
                        System.out.println("총 대여 기간 : " + borrowDays + "일");
                        System.out.println("기본 대여 기간을 초과하셨습니다. 추가 요금 " + (borrowDays - 3) * 1000 + "원을 납부해주십시오.");
                        System.out.println(bookList.get(rb).getBookTitle() + "(" + bookList.get(rb).getAuthor() + ") 도서가 반납되었습니다.");
                        bookList.get(rb).setReturnDate(rd);
                        bookList.get(rb).setStatus(0);
                    } else {
                        System.out.println("총 대여 기간 : " + borrowDays + "일");
                        System.out.println(bookList.get(rb).getBookTitle() + "(" + bookList.get(rb).getAuthor() + ") 도서가 반납되었습니다.");
                        bookList.get(rb).setReturnDate(rd);
                        bookList.get(rb).setStatus(0);
                    }
                } catch (ParseException e) {
                    System.out.println("반납일 입력 형식이 잘못 되었습니다. (ex: yyyyMMdd)");
                }
            }
        } else {
            throw new Exception();
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
