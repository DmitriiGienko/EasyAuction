package ru.skypro.coursework.easyauction.service;

import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.interfaces.FullLot;
import ru.skypro.coursework.easyauction.dto.LotDTO;
import ru.skypro.coursework.easyauction.model.Status;

import java.io.IOException;
import java.util.List;

public interface LotService {

    BidderDTO getFirstBidderName(int id);

    BidderDTO getBidderWithMaxBid(int id);

    FullLot getFullLotInfoByID(int id);

    void getStartBidding(int id);

    String createBid(int id, String bidderName);

    void getStopBidding(int id);

    LotDTO createLot(LotDTO lotDTO);

    List<LotDTO> getAllLotsByFilter(Status status, int page);

    byte[] createLotsFile() throws IOException;


}
