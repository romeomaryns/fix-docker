package eu.maryns.fix.source.prices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface PriceRepository extends PagingAndSortingRepository<Price, String> {

    @RestResource(rel = "by-instrument")
    Page<Price> findByInstrument(
            @Param("instrument") String instrument, Pageable pageable);
}
