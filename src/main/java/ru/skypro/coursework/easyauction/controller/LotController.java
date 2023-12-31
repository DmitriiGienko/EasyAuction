package ru.skypro.coursework.easyauction.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.coursework.easyauction.dto.*;
import ru.skypro.coursework.easyauction.exceptions.LotCreateException;
import ru.skypro.coursework.easyauction.interfaces.FullLot;
import ru.skypro.coursework.easyauction.model.Status;
import ru.skypro.coursework.easyauction.service.LotServiceImpl;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lot")
@AllArgsConstructor
public class LotController {

    private final LotServiceImpl lotService;

    @GetMapping("/{id}/first")
    @Operation(summary = "Получить информацию о первом ставившем на лот",
            description = "Возвращает первого ставившего на этот лот")
    public BidderDTO getFirstBidderName(@PathVariable int id) {
        return lotService.getFirstBidderName(id);
    }

    @GetMapping("/{id}/frequent")
    @Operation(summary = "Возвращает имя ставившего на данный лот наибольшее количество раз",
            description = "Наибольшее количество вычисляется из общего количества ставок на лот")
    public BidderDTO getBidderWithMaxBid(@PathVariable int id) {
        return lotService.getBidderWithMaxBid(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить полную информацию о лоте",
            description = "Возвращает полную информацию о лоте с последним ставившим и текущей ценой")
    public FullLot getFullLotInfoByID(@PathVariable int id) {
        return lotService.getFullLotInfoByID(id);
    }

    @PutMapping("/{id}/start")
    @Operation(summary = "Начать торги по лоту",
            description = """
                       Переводит лот в состояние начато, которое позволяет делать ставки на лот.
                    Если лот уже находится в состоянии начато, то ничего не делает и возвращает 200""")
    public void getStartBidding(@PathVariable int id) {
        lotService.getStartBidding(id);
    }

    @PutMapping("/{id}/bid")
    @Operation(summary = "Создает новую ставку по лоту.",
            description = """
                    Создает новую ставку по лоту.
                    Если лот в статусе CREATED или STOPPED, то должна вернутся ошибка""")
    public String getBid(@PathVariable int id,
                         @RequestParam("Bidder name") String bidderName) {
        return lotService.createBid(id, bidderName);
    }

    @PutMapping("/{id}/stop")
    @Operation(summary = "Остановить торги по лоту",
            description = """
                    Переводит лот в состояние остановлен, которое запрещает делать ставки на лот.
                    Если лот уже находится в состоянии остановлен, то ничего не делает и возвращает 200""")
    public void getStopBidding(@PathVariable int id) {
        lotService.getStopBidding(id);
    }

    @PostMapping("/lot")
    @Operation(summary = "Создание  лота",
            description = """
                    Метод создания нового лота,
                    если есть ошибки в полях объекта лота - то нужно вернуть статус с ошибкой""")
    public LotDTO createLot(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("startPrice") int startPrice,
                            @RequestParam("bidPrice") int bidPrise) {
        if (title.isBlank() || description.isBlank() || startPrice <= 0 || bidPrise <= 0) {
            throw new LotCreateException();
        }
        return lotService.createLot(new LotDTO(
                Status.CREATED.toString(),
                title,
                description,
                startPrice,
                bidPrise));
    }

    @GetMapping("/LotPages")
    @Operation(summary = "Получить все лоты, основываясь на фильтре статуса и номере страницы",
            description = """
                    Возвращает все записи о лотах без информации о текущей цене и победителе постранично.
                    Если страница не указана, то возвращается первая страница.
                    Номера страниц начинаются с 0.
                    Лимит на количество лотов на странице - 10 штук.""")
    public List<LotDTO> getAllLotsByFilter
            (@RequestParam(value = "status", defaultValue = "CREATED") Status status,
             @RequestParam(required = false, defaultValue = "0") int page) {
        return lotService.getAllLotsByFilter(status, page);
    }

    @PostMapping(value = "/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Operation(summary = "Экспортировать все лоты в файл CSV",
            description = """
                    Экспортировать все лоты в формате id, title, status, lastBidder, currentPrice
                    в одном файле CSV""")
    public ResponseEntity<byte[]> createLotsFile() {

        byte[] bytes = new byte[0];
        try {
            bytes = lotService.createLotsFile();
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "LotsInfo.csv" + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(bytes);
    }

}
