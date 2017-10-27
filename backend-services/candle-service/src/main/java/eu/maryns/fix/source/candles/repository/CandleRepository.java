package eu.maryns.fix.source.candles.repository;

import eu.maryns.fix.source.candles.model.Candle;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CandleRepository extends PagingAndSortingRepository<Candle, Long> {
}
