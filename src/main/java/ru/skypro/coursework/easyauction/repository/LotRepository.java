package ru.skypro.coursework.easyauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.coursework.easyauction.dto.TestDTO;
import ru.skypro.coursework.easyauction.model.Bid;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.progections.FullLotInfo;

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


}
