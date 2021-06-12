package com.muten.member;

public class Board {
    private static int indexNo = 1;
    private int boardID;
    private String title;
    private Member member;
    private String contents;

    public Board(String title, Member member, String contents) {
        this.boardID = indexNo;
        this.title = title;
        this.member = member;
        this.contents = contents;
        indexNo++;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardID=" + boardID +
                ", title='" + title + '\'' +
                ", member=" + member +
                ", contents='" + contents + '\'' +
                '}';
    }

    public int getBoardID() {
        return boardID;
    }

    public void setBoardID(int boardID) {
        this.boardID = boardID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
