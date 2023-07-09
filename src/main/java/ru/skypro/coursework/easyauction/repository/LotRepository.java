package ru.skypro.coursework.easyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.coursework.easyauction.dto.FullLotInfoDTO;
import ru.skypro.coursework.easyauction.dto.LotDTO;
import ru.skypro.coursework.easyauction.dto.TestDTO;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;
import ru.skypro.coursework.easyauction.progections.LotInfo;

import java.util.List;

@Repository
public interface LotRepository extends JpaRepository<Lot, Integer> {

    Lot getLotByTitle(String title);

    Lot getLotById(int id);

    @Query("SELECT new ru.skypro.coursework.easyauction.dto.TestDTO " +
            "(l.title, b.bidderName) FROM Lot l JOIN FETCH Bid b ON b.bidId = :id")
    TestDTO getTest(@Param("id") int id);

    //   @Query("SELECT ru.skypro.coursework.easyauction.progections.FullLotInfo " +
    //           "(l) FROM Lot l")
    //   FullLotInfo getFullLotInfo(int id);

    //   @Query("SELECT l FROM Lot l WHERE l.id = 1")
    //   Lot getLot(int id);

    @Query("SELECT new ru.skypro.coursework.easyauction.progections.FullLotInfo" +
            "(l.id, l.status, l.title, l.description, l.startPrice, l.bidPrice," +
            "(SELECT (COUNT(b.lot.id) * b.lot.bidPrice+ b.lot.startPrice) FROM Bid b)," +
//            "b.lot.bidPrice+ b.lot.startPrice + (COUNT(b.lot.id) FROM Bid b WHERE )," +
            " b.bidderName, b.bidderDateTime)" +
            " FROM Lot l" +
            " JOIN FETCH Bid b" +
            " ON l.id = :id AND b.bidderDateTime = (SELECT MAX (b.bidderDateTime) from Bid b)")
    FullLotInfo getFullInfo(@Param("id") int id);


    @Query(value = "SELECT title, bidder_name FROM lot JOIN bid" +
            " WHERE id = 1",
    nativeQuery = true)
    List<FullLotInfoDTO> getTitle(@Param("id") int id);

//    SELECT id,
//            status,
//            title,
//            start_price,
//            bid_price,
//       ((SELECT count(lot_id) FROM bid WHERE lot_id = 1) * bid_price + start_price) AS current,
//            bidder_name,
//            bidder_date_time
//    FROM lot
//    JOIN bid
//    ON lot.id = bid.lot_id AND bidder_date_time =
//            (SELECT max(bidder_date_time)
//    FROM bid)


    //          "WHERE lot_id = :id GROUP BY bidder_name ORDER BY count(*) DESC LIMIT 1",
    //          nativeQuery = true)

}
