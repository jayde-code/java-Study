package com.muten.member;

public interface MemberService {
    abstract void init();
    abstract void insertMember();
    abstract void updateMember();
    abstract void deleteMember();
    abstract void showAll();
    abstract Member findById(String id);
}
