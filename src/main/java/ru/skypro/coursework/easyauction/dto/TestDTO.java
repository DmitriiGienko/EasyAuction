package ru.skypro.coursework.easyauction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestDTO {
    private String title;
    private String bidderName;

    public TestDTO(String title, String bidderName) {
        this.title = title;
        this.bidderName = bidderName;
    }
}
