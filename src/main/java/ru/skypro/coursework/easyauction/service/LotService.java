package ru.skypro.coursework.easyauction.service;

import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.dto.FullLot;
import ru.skypro.coursework.easyauction.dto.LotDTO;

import java.util.List;

public interface LotService {

    BidderDTO getFirstBidderName(int id);

    BidderDTO getBidderWithMaxBid(int id);

    FullLot getFullLotInfoByID(int id);

    void getStartBidding(int id);

    String createBid(int id, String bidderName);

    void getStopBidding(int id);

    LotDTO createLot(LotDTO lotDTO);

    List<LotDTO> getAllLotsByFilter(int page);

    void createLotsFile();


}
