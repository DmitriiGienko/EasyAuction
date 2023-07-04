package ru.skypro.coursework.easyauction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.progections.Bidder;

@Data
@NoArgsConstructor
public class FullLotInfoDTO {
    private Lot lot;
    private int currentPrice;
    private Bidder bidder;
}
