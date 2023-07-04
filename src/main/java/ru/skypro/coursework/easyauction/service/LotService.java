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

    BidderDTO getBid(int id);

    void getStopBidding(int id);

    LotDTO createLot();

    List<LotDTO> getAllLotsByFilter(int page);

    void createLotsFile();


}
