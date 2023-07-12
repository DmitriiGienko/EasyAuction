package ru.skypro.coursework.easyauction.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({"id", "status", "title", "description", "startPrice",
        "bidPrice", "currentPrice", "lastBidderName", "lastBidderDateTime"})
public interface FullLot {
    int getId();

    String getStatus();

    String getTitle();

    String getDescription();

    int getStartPrice();

    int getBidPrice();

    int getCurrentPrice();

    String getLastBidderName();

    LocalDateTime getLastBidderDateTime();
}

