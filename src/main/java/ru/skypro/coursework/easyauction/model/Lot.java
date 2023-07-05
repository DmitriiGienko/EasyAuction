package ru.skypro.coursework.easyauction.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "lot")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private String title;
    private String description;
    @Column(name = "start_price")
    private int startPrice;
    @Column(name = "bid_price")
    private int bidPrice;

    //   public Lot(String title, String description, int startPrice, int bidPrice) {
    //       this.title = title;
    //       this.description = description;
    //       this.startPrice = startPrice;
    //       this.bidPrice = bidPrice;
    //   }

    public Lot(String status, String title, String description, int startPrice, int bidPrice) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
    }

    public Lot(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Лот " +
                "id: " + id +
                ", статус: " + status +
                ", название: " + title +
                ", описание: " + description +
                ", начальная цена: " + startPrice +
                ", цена ставки: " + bidPrice;
    }

}
