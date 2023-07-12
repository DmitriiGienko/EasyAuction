package ru.skypro.coursework.easyauction.interfaces;

import lombok.Getter;

import java.time.LocalDateTime;


public interface LotsForExport {
    int getId();
    String getStatus();
    String getTitle();
    int getCurrentPrice();
    String getLastBidderName();




}
