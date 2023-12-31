package ru.skypro.coursework.easyauction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BidDTO {
    private String bidderName;
    private LocalDateTime bidderDateTime;
    private LotDTO lotDTO;

}
