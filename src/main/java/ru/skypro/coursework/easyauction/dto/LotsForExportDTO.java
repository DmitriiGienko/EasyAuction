package ru.skypro.coursework.easyauction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skypro.coursework.easyauction.progections.Bidder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotsForExportDTO{
   private int id;
   private String status;
   private String title;
   private int currentPrice;
   private String bidder;

}
