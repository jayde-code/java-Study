package com.jayde.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Account> acc_list = new ArrayList();
    private static final Scanner sc = new Scanner(System.in);

    private static void createAcc() {
//        계좌번호 랜덤 생성
        String acc_no = String.format("%03d", (int)(Math.random() * 1000) - 1) + "-"
                + String.format("%03d", (int)(Math.random() * 1000 - 1));
        System.out.print("name? ");
        String name = sc.nextLine();
        System.out.print("balance? ");
        int balance = sc.nextInt();

        acc_list.add(new Account(name, acc_no, balance));
    }

    private static void readAcc() {
        for (Account i : acc_list) {
            System.out.println(i.toString());
        }
    }

    private static void deposit() {
        for (Account i : acc_list) {
            System.out.println("|" + acc_list.indexOf(i) + "|" + i.toString());
        }
//        관리하기 용이하게 인덱스 번호로 설정
        System.out.print("입금할 계좌의 인덱스 번호? ");
        int index_no = sc.nextInt();
        System.out.print("입금할 금액 : ");
        int dep = sc.nextInt();
        for (Account i : acc_list) {
            if (acc_list.indexOf(i) == index_no) {
                i.setBalance(i.getBalance() + dep);
                System.out.println("예금 성공");
                break;
            }
        }
    }

    private static void withdraw() {
        for (Account i : acc_list) {
            System.out.println("|" + acc_list.indexOf(i) + "|" + i.toString());
        }
        System.out.print("출금할 계좌의 인덱스 번호? ");
        int index_no = sc.nextInt();
        System.out.print("출금할 금액 : ");
        int with = sc.nextInt();
        for (Account i : acc_list) {
            if (i.getBalance() >= with && acc_list.indexOf(i) == index_no) {
                i.setBalance(i.getBalance() - with);
                System.out.println("출금 성공");
            } else {
                System.out.println("출금하려는 금액이 예금액보다 적습니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Jay BANK =====");
        while (true) {
            System.out.println("1Create 2Read 3Deposit 4Withdraw 0EXIT");
            System.out.print("INPUT>> ");
            String input_no = sc.nextLine();

            if (input_no.equals("1")) createAcc();
            else if (input_no.equals("2")) readAcc();
            else if (input_no.equals("3")) deposit();
            else if (input_no.equals("4")) withdraw();
            else if (input_no.equals("0")) break;
        }
    }
}
