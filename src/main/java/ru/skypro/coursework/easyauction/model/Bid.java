package ru.skypro.coursework.easyauction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private int bidId;
    @Column(name = "bidder_name")
    private String bidderName;
    @Column(name = "bidder_date_time")
    private LocalDateTime bidderDateTime;

    public Bid(String bidderName, LocalDateTime bidderDateTime) {
        this.bidderName = bidderName;
        this.bidderDateTime = bidderDateTime;

    }

    @Override
    public String toString() {
        return "Ставка: " +
                "имя покупателя: " + bidderName +
                ", дата и время ставки: " + bidderDateTime;
    }

    @ManyToOne(optional = false)
    private Lot lots;

    public Lot getLots() {
        return lots;
    }

    public void setLots(Lot lots) {
        this.lots = lots;
    }
}
