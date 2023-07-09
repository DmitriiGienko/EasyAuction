package ru.skypro.coursework.easyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.coursework.easyauction.dto.FullLot;
import ru.skypro.coursework.easyauction.dto.TestDTO;
import ru.skypro.coursework.easyauction.model.Lot;

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
    Optional<FullLot> getFullInfo(@Param("id")int id);
// проверен через БД, все выдает как надо
//    SELECT id,
//    status, title, description, start_price, bid_price,
//    (start_price+bid_price*(SELECT count(lot_id) FROM bid WHERE lot_id = id)) AS current,
//    bidder_name, bidder_date_time
//    FROM lot JOIN bid ON lot.id = : id
//    AND bidder_date_time = (SELECT max(bidder_date_time) FROM bid)

}
