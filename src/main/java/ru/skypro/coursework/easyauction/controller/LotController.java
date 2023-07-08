package ru.skypro.coursework.easyauction.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.dto.FullLotInfoDTO;
import ru.skypro.coursework.easyauction.dto.LotDTO;
import ru.skypro.coursework.easyauction.dto.TestDTO;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.model.Status;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;
import ru.skypro.coursework.easyauction.service.LotServiceImpl;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lot")
@AllArgsConstructor
public class LotController {

    private final LotServiceImpl lotService;

    @GetMapping("/{id}/first") // вернуть имя поставившим ставу первым
    public BidderDTO getFirstBidderName(@PathVariable int id) {
        return lotService.getFirstBidderName(id);
    }

    @GetMapping("/{id}/frequent") // Возвращает имя ставившего на данный лот наибольшее количество раз
    public BidderDTO getBidderWithMaxBid(@PathVariable int id) {
        return lotService.getBidderWithMaxBid(id);
    }

    @GetMapping("/{id}") // Возвращает полную информацию о лоте с последним ставившим и текущей ценой
    public FullLotInfo getFullLotInfoByID(@PathVariable int id) {
        return lotService.getFullLotInfoByID(id);
    }

    @PutMapping("/{id}/start") // Начать торги по лоту
    public void getStartBidding(@PathVariable int id) {
        lotService.getStartBidding(id);
    }

    @PutMapping("/{id}/bid") // Сделать ставку по лоту
    public String getBid(@PathVariable int id,
                         @RequestParam("Bidder name") String bidderName) {
        return lotService.createBid(id, bidderName);
    }

    @PutMapping("/{id}/stop") // Остановить торги по лоту
    public void getStopBidding(@PathVariable int id) {
        lotService.getStopBidding(id);

    }

    @PostMapping("/lot") // создание лота
    public LotDTO createLot(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("startPrice") int startPrice,
                            @RequestParam("bidPrice") int bidPrise) {
        return lotService.createLot(new LotDTO(
                Status.CREATED.toString(),
                title,
                description,
                startPrice,
                bidPrise));
    }

    @GetMapping("/LotPages")
    public List<LotDTO> getAllLotsByFilter // Получить все лоты, основываясь на фильтре статуса и номере страницы
// уточни и почитай про это
    (@RequestParam(required = false, defaultValue = "0") int page) {
        return lotService.getAllLotsByFilter(page);
    }

    @PostMapping("export") //  Экспортировать все лоты в файл CSV
    public void createLotsFile() {
        lotService.createLotsFile();
        //  try {
        //      return reportService.addReport();
        //  } catch (IOException e) {
        //      throw new RuntimeException(e);
        //  }
    }

    @GetMapping("/testLot")
    public TestDTO getLot(@RequestParam int id) {
        return lotService.getLot(id);
    }
}
