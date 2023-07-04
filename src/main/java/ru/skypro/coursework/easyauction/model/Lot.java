package ru.skypro.coursework.easyauction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Lot {
    private int id;
    private String status = Status.CREATED.toString();
    private String title;
    private String description;
    private int startPrice;
    private int bidPrice;

    public Lot(String title, String description, int startPrice, int bidPrice) {
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
