package com.muten.market;

public class Member {
    private static int indexNo = 1;
    private int memberId;
    private String userName;
    private String password;

    public Member(String userName, String password) {
        this.memberId = indexNo;
        this.userName = userName;
        this.password = password;
        indexNo++;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

