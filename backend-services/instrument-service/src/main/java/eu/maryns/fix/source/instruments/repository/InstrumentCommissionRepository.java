package eu.maryns.fix.source.instruments.repository;


import eu.maryns.fix.source.instruments.model.InstrumentCommission;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "instrumentCommissions", path = "instrumentCommissions")
public interface InstrumentCommissionRepository extends Neo4jRepository<InstrumentCommission, Long> {
    Optional<InstrumentCommission> findByInstrument(String instrument);

    @Override
    Iterable<InstrumentCommission> findAll();
}
