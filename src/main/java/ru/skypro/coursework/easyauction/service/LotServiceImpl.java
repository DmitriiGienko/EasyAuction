package ru.skypro.coursework.easyauction.service;

import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.skypro.coursework.easyauction.dto.*;
import ru.skypro.coursework.easyauction.exceptions.LotErrorStatusException;
import ru.skypro.coursework.easyauction.exceptions.LotNotFoundException;
import ru.skypro.coursework.easyauction.interfaces.FullLot;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.model.Status;
import ru.skypro.coursework.easyauction.progections.Bidder;
import ru.skypro.coursework.easyauction.repository.BidRepository;
import ru.skypro.coursework.easyauction.repository.LotRepository;
import ru.skypro.coursework.easyauction.repository.PagingLotRepository;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class LotServiceImpl implements LotService {

    private final LotRepository lotRepository;
    private final BidRepository bidRepository;
    private final PagingLotRepository pagingLotRepository;
    private final MapperClass mapperClass;

    @Override
    public BidderDTO getFirstBidderName(int id) {
        Bidder bidder = bidRepository.findFirstBidder(id).orElseThrow(LotNotFoundException::new);
        return MapperClass.toBidderDTO(bidder);
    }

    @Override
    public BidderDTO getBidderWithMaxBid(int id) {
        Bidder bidder = bidRepository.findMaxBidder(id).orElseThrow(LotNotFoundException::new);
        return MapperClass.toBidderDTO(bidder);
    }

    @Override
    public FullLot getFullLotInfoByID(int id) {
        return lotRepository.getFullInfo(id).orElseThrow(LotNotFoundException::new);
    }

    @Override
    public void getStartBidding(int id) {
        Lot lot = lotRepository.findById(id).orElseThrow(LotNotFoundException::new);
        lot.setStatus(Status.STARTED.toString());
        lotRepository.save(lot);
    }

    @Override
    public String createBid(int id, String bidderName) {

        Lot lot = lotRepository.findById(id).orElseThrow(LotNotFoundException::new);
        if (lot.getStatus().equals(Status.STARTED.toString())) {
            bidRepository.save(new Bid(bidderName, LocalDateTime.now(), lot));
            return bidderName;
        } else throw new LotErrorStatusException();
    }

    @Override
    public void getStopBidding(int id) {
        Lot lot = lotRepository.findById(id).orElseThrow(LotNotFoundException::new);
        lot.setStatus(Status.STOPPED.toString());
        lotRepository.save(lot);
    }

    @Override
    public LotDTO createLot(LotDTO lotDTO) {
        Lot lot = MapperClass.fromLotDTO(lotDTO);
        lotRepository.save(lot);
        return MapperClass.toLotDTO(lotRepository.getLotByTitle(lotDTO.getTitle()));
    }

    @Override
    public List<LotDTO> getAllLotsByFilter(Status status, int page) {

        Pageable lotOfPage = PageRequest.of(page, 10);
        Page<Lot> lotPage = pagingLotRepository.findAllByStatus(status.toString(), lotOfPage);
        return lotPage.stream()
                .toList()
                .stream().map(MapperClass::toLotDTO)
                .collect(Collectors.toList());
    }

    @Override
    public byte[] createLotsFile() throws IOException {

        StringWriter sw = new StringWriter();

        List<LotsForExportDTO> lotsForExportDTOS = lotRepository.findAll()
                .stream().map(mapperClass::toLotsForExportDTO)
                .toList();

        try (CSVPrinter csvPrinter = new CSVPrinter(sw, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("id", "status", "title", "currentPrice", "bidder");
            for (LotsForExportDTO lotsForExportDTO : lotsForExportDTOS) {
                csvPrinter.printRecord(lotsForExportDTO.getId(),
                        lotsForExportDTO.getStatus(),
                        lotsForExportDTO.getTitle(),
                        lotsForExportDTO.getCurrentPrice(),
                        lotsForExportDTO.getBidder());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = "LotsInfo.csv";
        Path path = Paths.get(fileName);
        Files.write(path, sw.toString().getBytes(StandardCharsets.UTF_8));

        return sw.toString().getBytes(StandardCharsets.UTF_8);
    }


}

