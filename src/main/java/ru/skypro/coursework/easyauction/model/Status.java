package ru.skypro.coursework.easyauction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum Status {
    CREATED("CREATED"),
    STARTED("STARTED"),
    STOPPED("STOPPED");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
