package eu.maryns.fix.source.prices.repository;

import eu.maryns.fix.source.prices.model.Price;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PriceRepository extends PagingAndSortingRepository<Price, String> {
}
