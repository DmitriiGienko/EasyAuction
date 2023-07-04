package ru.skypro.coursework.easyauction.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.progections.Bidder;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lot")
public class LotController {

    @GetMapping("/{id}/first") // вернуть имя поставившим ставу первым
    public Bidder getFirstBidderName(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}/frequent") // Возвращает имя ставившего на данный лот наибольшее количество раз
    public Bidder getBidderWithMaxBid(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}") // Возвращает полную информацию о лоте с последним ставившим и текущей ценой
    public FullLotInfo getFullLotInfoByID(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}/start") // Начать торги по лоту
    public void getStartBidding(@PathVariable int id) {

    }

    @PutMapping("/{id}/bid") // Сделать ставку по лоту
    public Bidder getBid(@PathVariable int id) {
        return null;
    }

    @PutMapping("/{id}/stop") // Остановить торги по лоту
    public void getStopBidding(@PathVariable int id) {

    }

    @PostMapping("/lot") // создание лота
    public Lot createLot() {
        return null;
    }

    @GetMapping("/LotPages")
    public List<Lot> getAllLotsByFilter // Получить все лоты, основываясь на фильтре статуса и номере страницы
// уточни и почитай про это
    (@RequestParam(required = false, defaultValue = "0") int page) {
        return null;
    }

    @PostMapping("export") //  Экспортировать все лоты в файл CSV
    public void createLotsFile() {

        //  try {
        //      return reportService.addReport();
        //  } catch (IOException e) {
        //      throw new RuntimeException(e);
        //  }
    }
}
