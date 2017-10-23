package eu.maryns.fix.source.instruments;

import eu.maryns.fix.source.instruments.Instrument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface InstrumentRepository extends PagingAndSortingRepository<Instrument, String> {
}
