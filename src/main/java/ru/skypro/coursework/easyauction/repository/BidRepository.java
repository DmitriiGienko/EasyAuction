package ru.skypro.coursework.easyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.coursework.easyauction.dto.BidderDTO;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.progections.Bidder;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

    @Query("SELECT new ru.skypro.coursework.easyauction.progections.Bidder" +
            "(b.bidderName, b.bidderDateTime) FROM Bid b WHERE b.lot.id = :id" +
            " AND b.bidderDateTime = (SELECT MIN (b.bidderDateTime) from Bid b WHERE b.lot.id = :id)")
    Optional<Bidder> findFirstBidder(@Param("id") int id);

    @Query("SELECT new ru.skypro.coursework.easyauction.progections.Bidder" +
            "(b.bidderName, b.bidderDateTime) FROM Bid b WHERE b.lot.id = :id" +
            " AND b.bidderDateTime = (SELECT MAX (b.bidderDateTime) from Bid b WHERE b.lot.id = :id)")
    Optional<Bidder> findLastBidder(@Param("id") int id);


    @Query("SELECT new ru.skypro.coursework.easyauction.progections.Bidder" +
            "(b.bidderName,MAX(b.bidderDateTime)) FROM Bid b WHERE b.lot.id = :id " +
            "GROUP BY b.bidderName ORDER BY COUNT(b.lot.id) DESC LIMIT 1")
    Optional<Bidder> findMaxBidder(@Param("id") int id);


}
