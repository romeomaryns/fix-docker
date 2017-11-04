package eu.maryns.fix.source.instruments.repository;

import eu.maryns.fix.source.instruments.model.Instrument;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "instruments", path = "instruments")
public interface InstrumentRepository extends Neo4jRepository<Instrument, Long> {
    Optional<Instrument> findByName(String name);
    @Override
    Iterable<Instrument> findAll();

    List<Instrument> findByDisplayName(String filterText);
}
