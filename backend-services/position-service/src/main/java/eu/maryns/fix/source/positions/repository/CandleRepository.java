package eu.maryns.fix.source.candles.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CandleRepository extends PagingAndSortingRepository<Candle, Long> {
    Iterable<Candle> findAllByInstrument(Iterable<String> instruments);
}
