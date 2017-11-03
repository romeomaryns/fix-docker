package eu.maryns.fix.source.instruments.service;

import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.model.InstrumentCommission;
import eu.maryns.fix.source.instruments.repository.InstrumentCommissionRepository;
import eu.maryns.fix.source.instruments.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository repository;
    @Autowired
    private InstrumentCommissionRepository icRepository;

    public Instrument save(Instrument instrument) {
        Optional<Instrument> dbInstrument = repository.findByName(instrument.getName());
        if(!dbInstrument.isPresent())
        {
            return repository.save(instrument);
        }
        return null;
    }

    public void clean() {
        repository.deleteAll();
    }
}
