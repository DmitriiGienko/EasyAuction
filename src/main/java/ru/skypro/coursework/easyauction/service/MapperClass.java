package ru.skypro.coursework.easyauction.service;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.skypro.coursework.easyauction.dto.*;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.progections.Bidder;
import ru.skypro.coursework.easyauction.repository.BidRepository;

import java.util.Objects;

@Component
@AllArgsConstructor
public class MapperClass {

    private final BidRepository bidRepository;

    public static LotDTO toLotDTO(Lot lot) {
        LotDTO lotDTO = new LotDTO();
        lotDTO.setId(lot.getId());
        lotDTO.setStatus(lot.getStatus());
        lotDTO.setTitle(lot.getTitle());
        lotDTO.setDescription(lot.getDescription());
        lotDTO.setStartPrice(lot.getStartPrice());
        lotDTO.setBidPrice(lot.getBidPrice());
        return lotDTO;
    }

    public static Lot fromLotDTO(LotDTO lotDTO) {
        Lot lot = new Lot();
        lot.setId(lotDTO.getId());
        lot.setStatus(lotDTO.getStatus());
        lot.setTitle(lotDTO.getTitle());
        lot.setDescription(lotDTO.getDescription());
        lot.setStartPrice(lotDTO.getStartPrice());
        lot.setBidPrice(lotDTO.getBidPrice());
        return lot;
    }


    public static BidderDTO toBidderDTO(Bidder bidder) {
        BidderDTO bidderDTO = new BidderDTO();
        bidderDTO.setBiddersName(bidder.getBiddersName());
        bidderDTO.setLocalDateTimeOfBid(bidder.getLocalDateTimeOfBid());
        return bidderDTO;
    }

    public static Bidder fromBidderDTO(BidderDTO bidderDTO) {
        Bidder bidder = new Bidder();
        bidder.setBiddersName(bidderDTO.getBiddersName());
        bidder.setLocalDateTimeOfBid(bidderDTO.getLocalDateTimeOfBid());
        return bidder;
    }

    public LotsForExportDTO toLotsForExportDTO(Lot lot) {
        LotsForExportDTO lotsForExportDTO = new LotsForExportDTO();
        lotsForExportDTO.setId(lot.getId());
        lotsForExportDTO.setTitle(lot.getTitle());
        lotsForExportDTO.setStatus(lot.getStatus());
        lotsForExportDTO.setCurrentPrice(lot.getBidList().size() * lot.getBidPrice() + lot.getStartPrice());
        if (getNameLastBidder(lot) == null) {
            lotsForExportDTO.setBidder("Нет данных");
        } else {
            lotsForExportDTO.setBidder(getNameLastBidder(lot).getBiddersName());
        }
        return lotsForExportDTO;
    }

    public Bidder getNameLastBidder(Lot lot) {
        return bidRepository.findLastBidder(lot.getId()).orElse(null);
    }

}
