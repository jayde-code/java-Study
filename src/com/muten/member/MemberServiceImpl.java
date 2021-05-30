package com.muten.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Member> memberList = new ArrayList<>();

    @Override
    public void init() {
        System.out.print("[1] Insert Member\n" +
                "[2] Update Member\n" +
                "[3] Delete Member\n" +
                "[4] Show All\n" +
                "[0] EXIT\n" +
                ">> ");
        String menu = sc.nextLine();

        if (menu.equals("1")) insertMember();
        else if (menu.equals("2")) updateMember();
        else if (menu.equals("3")) deleteMember();
        else if (menu.equals("4")) showAll();
        else if (menu.equals("0")) System.exit(0);
    }

    @Override
    public void insertMember() {
        System.out.print("id? ");
        String id = sc.nextLine();
        System.out.print("pwd? ");
        String pwd = sc.nextLine();
        System.out.print("email? ");
        String email = sc.nextLine();
        Member member = new Member(id, pwd, email);
        memberList.add(member);
        System.out.println(member.getId() + "가 생성되었습니다.");
    }

    @Override
    public void updateMember() {
        System.out.print("id? ");
        String id = sc.nextLine();
        if (findById(id) == null) {
            System.out.println("존재하지 않는 아이디입니다.");
        } else {
            System.out.print("email? ");
            String email = sc.nextLine();
            findById(id).setEmail(email);
        }
    }

    @Override
    public void deleteMember() {
        System.out.print("id? ");
        String id = sc.nextLine();
        if (findById(id) == null) {
            System.out.println("존재하지 않는 아이디입니다.");
        } else {
            memberList.remove(findById(id));
        }
    }

    @Override
    public void showAll() {
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }

    @Override
    public Member findById(String id) {
        for (Member i : memberList) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
}


