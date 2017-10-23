package eu.maryns.fix.source.instruments;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface CandleRepository extends PagingAndSortingRepository<Candle, String> {
}
