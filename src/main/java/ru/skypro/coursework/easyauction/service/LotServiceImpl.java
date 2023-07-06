package ru.skypro.coursework.easyauction.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.dto.FullLotInfoDTO;
import ru.skypro.coursework.easyauction.dto.LotDTO;
import ru.skypro.coursework.easyauction.exceptions.LotNotFoundException;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.model.Status;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;
import ru.skypro.coursework.easyauction.repository.LotRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LotServiceImpl implements LotService {

    private final LotRepository lotRepository;

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
        Lot lot = lotRepository.findById(id).orElseThrow(LotNotFoundException::new);
        lot.setStatus(Status.STARTED.toString());
        lotRepository.save(lot);
    }

    @Override
    public BidderDTO getBid(int id) {
        return null;
    }

    @Override
    public void getStopBidding(int id) {

    }

    @Override
    public LotDTO createLot(LotDTO lotDTO) {
        Lot lot = MapperClass.fromLotDTO(lotDTO);
        lotRepository.save(lot);
        return MapperClass.toLotDTO(lotRepository.getLotByTitle(lotDTO.getTitle()));
    }

    @Override
    public List<LotDTO> getAllLotsByFilter(int page) {
        return null;
    }

    @Override
    public void createLotsFile() {

    }
}
