package ru.skypro.coursework.easyauction.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.coursework.easyauction.model.Lot;

public interface LotRepository extends CrudRepository<Lot, Integer> {
}
