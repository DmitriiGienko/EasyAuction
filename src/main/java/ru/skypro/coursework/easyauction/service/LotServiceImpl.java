package ru.skypro.coursework.easyauction.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.coursework.easyauction.dto.*;
import ru.skypro.coursework.easyauction.exceptions.LotErrorStatusException;
import ru.skypro.coursework.easyauction.exceptions.LotNotFoundException;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.model.Status;
import ru.skypro.coursework.easyauction.progections.Bidder;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;
import ru.skypro.coursework.easyauction.repository.BidRepository;
import ru.skypro.coursework.easyauction.repository.LotRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LotServiceImpl implements LotService {

    private final LotRepository lotRepository;
    private final BidRepository bidRepository;

    @Override
    public BidderDTO getFirstBidderName(int id) {
        Bidder bidder = bidRepository.findFirstBidder(id).orElseThrow(LotNotFoundException::new);
        return MapperClass.toBidderDTO(bidder);
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
    public String createBid(int id, String bidderName) {

        Lot lot = lotRepository.findById(id).orElseThrow(LotNotFoundException::new);
        if (lot.getStatus().equals(Status.STARTED.toString())) {
            // BidDTO bidDTO = new BidDTO(bidderName, LocalDateTime.now(), MapperClass.toLotDTO(lot));
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
    public List<LotDTO> getAllLotsByFilter(int page) {
        return null;
    }

    @Override
    public void createLotsFile() {
    }

    public TestDTO getLot(int id) {

        return lotRepository.getTest(id);

    }


}
