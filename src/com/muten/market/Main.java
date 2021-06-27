package com.muten.market;

public class Main {
    public static Boolean run = true;

    public static void main(String[] args) {
        while(run) {
            MarketServiceImpl marketService = new MarketServiceImpl();
            marketService.init();
        }
    }
}