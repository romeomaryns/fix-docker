package eu.maryns.fix.source.instruments.repository;

import eu.maryns.fix.source.instruments.model.Instrument;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface InstrumentRepository extends PagingAndSortingRepository<Instrument, Long> {
}
