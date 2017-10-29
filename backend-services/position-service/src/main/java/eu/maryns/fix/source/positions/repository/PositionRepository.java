package eu.maryns.fix.source.positions.repository;

import eu.maryns.fix.source.positions.model.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository extends PagingAndSortingRepository<Position, Long> {
}
