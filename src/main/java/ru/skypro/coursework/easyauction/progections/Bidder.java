package ru.skypro.coursework.easyauction.progections;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Bidder {
    private String biddersName;
    private LocalDateTime localDateTimeOfBid;

    public Bidder(String biddersName, LocalDateTime localDateTimeOfBid) {
        this.biddersName = biddersName;
        this.localDateTimeOfBid = localDateTimeOfBid;
    }


}
