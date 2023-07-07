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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    private Lot lot;


    public Bid(String bidderName, LocalDateTime bidderDateTime, Lot lot) {
        this.bidderName = bidderName;
        this.bidderDateTime = bidderDateTime;
        this.lot = lot;

    }

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

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public LocalDateTime getBidderDateTime() {
        return bidderDateTime;
    }

    public void setBidderDateTime(LocalDateTime bidderDateTime) {
        this.bidderDateTime = bidderDateTime;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
}
