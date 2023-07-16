package ru.skypro.coursework.easyauction.dto;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@NoArgsConstructor


public class LotDTO {
    private int id;
    private String status;
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;

    public LotDTO(String status, String title, String description, int startPrice, int bidPrice) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
    }
}
