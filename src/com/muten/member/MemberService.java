package com.muten.member;

public interface MemberService {
    abstract void init();
    abstract void signIn();
    abstract void delMember();
    abstract void showMember();
    abstract void login();
    abstract void logout();
    abstract void newBoard();
    abstract void searchBoard();
    abstract Member findById(String id);
}
