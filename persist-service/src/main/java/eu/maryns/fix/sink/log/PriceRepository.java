package eu.maryns.fix.sink.log;

import com.oanda.v20.pricing.Price;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.Instrument;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "prices", path = "prices")
public interface PriceRepository extends PagingAndSortingRepository<Price, String> {
    List<Price> findByTime(@Param("time")DateTime time);
    List<Instrument> findByInstrument(@Param("instrument")Instrument instrument);
}
