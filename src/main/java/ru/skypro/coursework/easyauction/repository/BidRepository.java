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

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

    @Query("SELECT new ru.skypro.coursework.easyauction.progections.Bidder" +
            "(b.bidderName, b.bidderDateTime) FROM Bid b WHERE b.lot.id = :id ORDER BY b.bidderDateTime")
   List<Bidder> Bidder findFirstBidder(@Param("id") int id);

}
