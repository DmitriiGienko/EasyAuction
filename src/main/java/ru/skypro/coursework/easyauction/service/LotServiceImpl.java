package ru.skypro.coursework.easyauction.service;

import org.springframework.stereotype.Service;
import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.dto.FullLotInfoDTO;
import ru.skypro.coursework.easyauction.dto.LotDTO;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;

import java.util.List;

@Service
public class LotServiceImpl implements LotService{
    @Override
    public BidderDTO getFirstBidderName(int id) {
        return null;
    }

    @Override
    public BidderDTO getBidderWithMaxBid(int id) {
        return null;
    }

    @Override
    public FullLotInfoDTO getFullLotInfoByID(int id) {
        return null;
    }

    @Override
    public void getStartBidding(int id) {

    }

    @Override
    public BidderDTO getBid(int id) {
        return null;
    }

    @Override
    public void getStopBidding(int id) {

    }

    @Override
    public LotDTO createLot() {
        return null;
    }

    @Override
    public List<LotDTO> getAllLotsByFilter(int page) {
        return null;
    }

    @Override
    public void createLotsFile() {

    }
}
