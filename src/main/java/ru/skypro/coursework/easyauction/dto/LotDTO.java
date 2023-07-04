package ru.skypro.coursework.easyauction.dto;

import lombok.Data;

@Data
public class LotDTO {
    private int id;
    private String status;
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;
}
