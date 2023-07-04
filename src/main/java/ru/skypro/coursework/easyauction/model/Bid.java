package ru.skypro.coursework.easyauction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Bid {
    private int bidId;
    private String bidderName;
    private final LocalDateTime bidderDateTime;

    public Bid(String bidderName, LocalDateTime bidderDateTime) {
        this.bidderName = bidderName;
        this.bidderDateTime = bidderDateTime;

    }

    @Override
    public String toString() {
        return "Ставка: " +
                "имя покупателя: " + bidderName +
                ", дата и время ставки: " + bidderDateTime;
    }
}
