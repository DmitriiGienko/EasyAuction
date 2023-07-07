package ru.skypro.coursework.easyauction.service;

import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.dto.FullLotInfoDTO;
import ru.skypro.coursework.easyauction.dto.LotDTO;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;

import java.util.List;

public interface LotService {

    BidderDTO getFirstBidderName(int id);

    BidderDTO getBidderWithMaxBid(int id);

    FullLotInfoDTO getFullLotInfoByID(int id);

    void getStartBidding(int id);

    String createBid(int id, String bidderName);

    void getStopBidding(int id);

    LotDTO createLot(LotDTO lotDTO);

    List<LotDTO> getAllLotsByFilter(int page);

    void createLotsFile();


}
