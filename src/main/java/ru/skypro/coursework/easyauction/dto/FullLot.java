package ru.skypro.coursework.easyauction.dto;

import java.time.LocalDateTime;

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

