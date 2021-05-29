package com.muten.member;

public class Main {
    public static Boolean run = true;

    public static void main(String[] args) {
        while(run) {
            MemberServiceImpl memberService = new MemberServiceImpl();
            memberService.init();
        }
    }
}
