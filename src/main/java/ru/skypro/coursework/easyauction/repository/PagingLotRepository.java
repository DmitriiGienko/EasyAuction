package ru.skypro.coursework.easyauction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.coursework.easyauction.model.Lot;
import ru.skypro.coursework.easyauction.model.Status;

public interface PagingLotRepository extends PagingAndSortingRepository<Lot, Integer> {

    Page<Lot> findAllByStatus(String status, Pageable pageable);
}
