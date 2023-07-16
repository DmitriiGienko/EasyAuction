package ru.skypro.coursework.easyauction.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BidderDTO {
    private String biddersName;
    private LocalDateTime localDateTimeOfBid;
}
