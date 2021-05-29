package com.muten.member;

public interface MemberService {
    public void init();
    public void insertMember();
    public void updateMember();
    public void deleteMember();
    public void showAll();
    public Member findById(String id);
}
