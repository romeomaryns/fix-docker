package eu.maryns.fix.source.instruments.service;

import eu.maryns.fix.source.instruments.model.InstrumentCommission;
import eu.maryns.fix.source.instruments.repository.InstrumentCommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstrumentCommissionService {

    @Autowired
    private InstrumentCommissionRepository repository;


    public InstrumentCommission save(InstrumentCommission instrumentCommission) {
        Optional<InstrumentCommission> dbInstrumentCommission = repository.findByInstrument(instrumentCommission.getInstrument());
        return dbInstrumentCommission.<InstrumentCommission>map(instrumentCommission1 -> null).orElseGet(() -> repository.save(instrumentCommission));
    }

    public void clean() {
        repository.deleteAll();
    }
}
