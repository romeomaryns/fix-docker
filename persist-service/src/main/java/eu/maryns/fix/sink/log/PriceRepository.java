package eu.maryns.fix.sink.log;

import com.oanda.v20.pricing.Price;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.Instrument;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
/*
@RepositoryRestResource(collectionResourceRel = "prices", path = "prices")
public interface PriceRepository extends PagingAndSortingRepository<PriceJSON, String> {
    List<PriceJSON> findByTime(@Param("time")String time);
    List<PriceJSON> findByInstrument(@Param("instrument")String instrument);

    @Override
    <S extends PriceJSON> S save(S entity);
}
*/

public class PriceRepository{
}
