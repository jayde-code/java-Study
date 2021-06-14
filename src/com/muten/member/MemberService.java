package com.muten.member;

public interface MemberService {
    void init();
    void signIn();
    void delMember();
    void showMember();
    void login();
    void logout();
    void newBoard();
    void searchBoard();
    Member findById(String id);
}
