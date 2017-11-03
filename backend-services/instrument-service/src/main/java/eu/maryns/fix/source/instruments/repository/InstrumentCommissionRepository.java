package eu.maryns.fix.source.instruments.repository;

import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.model.InstrumentCommission;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "instrumentCommissions", path = "instrumentCommissions")
public interface InstrumentCommissionRepository extends Neo4jRepository<InstrumentCommission, Long> {
}
