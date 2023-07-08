package ru.skypro.coursework.easyauction.service;

public class ServiceUtil {

    public static int currentPrice(int startPrise, int bidPrice, int countOfBid) {
        return startPrise + bidPrice * countOfBid;
    }
}
