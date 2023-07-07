package ru.skypro.coursework.easyauction.progections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skypro.coursework.easyauction.model.Lot;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullLotInfo {
    private Lot lot;
    private int currentPrice;
    private Bidder bidder;

    //   @Override
    //   public String toString() {
    //       return "Полная информация по лоту: " +
    //               "lot=" + lot +
    //               ", текущая цена: " + currentPrice +
    //               ", bidder=" + bidder;
    //   }
}
