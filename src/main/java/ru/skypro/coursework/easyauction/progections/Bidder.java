package ru.skypro.coursework.easyauction.progections;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Bidder {
    private String biddersName;
    private LocalDateTime localDateTimeOfBid;

}
