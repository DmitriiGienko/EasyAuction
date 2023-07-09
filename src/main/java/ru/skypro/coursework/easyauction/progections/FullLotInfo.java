package ru.skypro.coursework.easyauction.progections;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skypro.coursework.easyauction.model.Lot;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FullLotInfo {
    // private Lot lot;
    // private int currentPrice;
    // private Bidder bidder;

    private int id;
    private String status;
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;
    private int correntPrice;
    private String biddersName;
    private LocalDateTime localDateTimeOfBid;
//    private Bidder bidder;

    public FullLotInfo(int id, String status, String title,
                       String description, int startPrice, int bidPrice,
                       int correntPrice, String biddersName, LocalDateTime localDateTimeOfBid) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
        this.correntPrice = correntPrice;
        this.biddersName = biddersName;
        this.localDateTimeOfBid = localDateTimeOfBid;
    }

//   public FullLotInfo(int id, String status, String title, String description,
//                      int startPrice, int bidPrice, int correntPrice, Bidder bidder) {
//       this.id = id;
//       this.status = status;
//       this.title = title;
//       this.description = description;
//       this.startPrice = startPrice;
//       this.bidPrice = bidPrice;
//       this.correntPrice = correntPrice;
//       this.bidder = bidder;
//   }
    //  public FullLotInfo(Lot lot, int currentPrice, Bidder bidder) {
    //      this.lot = lot;
    //      this.currentPrice = currentPrice;
    //      this.bidder = bidder;
    //  }

    //@Override
    //   public String toString() {
    //       return "Полная информация по лоту: " +
    //               "lot=" + lot +
    //               ", текущая цена: " + currentPrice +
    //               ", bidder=" + bidder;
    //   }
}
