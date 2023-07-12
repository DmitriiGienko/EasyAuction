package ru.skypro.coursework.easyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.coursework.easyauction.dto.FullLot;
import ru.skypro.coursework.easyauction.dto.LotsForExport;
import ru.skypro.coursework.easyauction.dto.LotsForExportDTO;
import ru.skypro.coursework.easyauction.model.Lot;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotRepository extends JpaRepository<Lot, Integer> {

    Lot getLotByTitle(String title);

    Lot getLotById(int id);


    @Query(value = "SELECT id, status, title, description, start_price AS startPrice, bid_price AS bidPrice, " +
            "(start_price+bid_price*(SELECT count(lot_id) FROM bid WHERE lot_id = id)) AS currentPrice, " +
            "bidder_name AS lastBidderName, bidder_date_time AS lastBidderDateTime " +
            "FROM lot JOIN bid ON id = :id AND bidder_date_time = (SELECT max(bidder_date_time) FROM bid WHERE id = lot_id)",
            nativeQuery = true)
    Optional<FullLot> getFullInfo(@Param("id") int id);


    @Query(value = """
             SELECT id, status, title, bidder_name AS lastBidderName,
             (start_price + bid_price * (SELECT count(lot_id) FROM bid WHERE lot_id = id))
              AS currentPrice FROM lot LEFT JOIN bid ON bidder_date_time = (SELECT max(bidder_date_time) 
              FROM bid WHERE id = lot_id)
            """, nativeQuery = true)
    List<LotsForExport> findAllLots();

 //   @Query("SELECT new ru.skypro.coursework.easyauction.dto.LotsForExportDTO " +
 //           "(l.id, l.title, l.status, " +
 //           "(SELECT COUNT(b.bidId) FROM Bid b WHERE b.lot.id = l.id) , b.bidderName) FROM Lot l LEFT JOIN Bid b" +
 //           " ON b.bidderDateTime = (SELECT MAX(b.bidderDateTime) FROM Bid b)")
 //   List<LotsForExportDTO> getLotsForExportDTO();


}
