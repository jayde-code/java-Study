package com.muten.market;

public interface MarketService {
    void init();
    void signIn();
    void login();
    void logout();
    void addCart();
    void cartList();
    void myInfo();
    boolean matches(String regex, CharSequence input);
    Member findById(String id);
}
