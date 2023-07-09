package ru.skypro.coursework.easyauction.service;

import ru.skypro.coursework.easyauction.dto.BidDTO;
import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.dto.LotDTO;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.progections.Bidder;

public class MapperClass {

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

    public static BidDTO toBidDTO(Bid bid) {
        return new BidDTO(bid.getBidderName(),
                bid.getBidderDateTime(),
                toLotDTO(new Lot()));
    }

    public static Bid fromBidDTO(BidDTO bidDTO) {
        return new Bid(bidDTO.getBidderName(),
                bidDTO.getBidderDateTime(),
                MapperClass.fromLotDTO(bidDTO.getLotDTO()));
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


}
