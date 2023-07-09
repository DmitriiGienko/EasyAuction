package ru.skypro.coursework.easyauction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.progections.Bidder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FullLotInfoDTO {
    private int id;
    private String status;
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;
    private int currentPrice;
    private String lastBidderName;
    private LocalDateTime lastBidderDateTime;
}
