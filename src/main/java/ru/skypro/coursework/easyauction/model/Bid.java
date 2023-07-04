package ru.skypro.coursework.easyauction.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Bid {
    private int bidId;
    private String bidderName;
    private final LocalDateTime bidderDateTime = LocalDateTime.now();

    public Bid(String bidderName) {
        this.bidderName = bidderName;
    }

    @Override
    public String toString() {
        return "Ставка: " +
                "имя покупателя: " + bidderName +
                ", дата и время ставки: " + bidderDateTime;
    }
}
