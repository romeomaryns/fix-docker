package eu.maryns.fix.source.instruments.service;

import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.model.InstrumentCommission;
import eu.maryns.fix.source.instruments.repository.InstrumentCommissionRepository;
import eu.maryns.fix.source.instruments.repository.InstrumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstrumentService {

    private final Logger log = LoggerFactory.getLogger(InstrumentService.class);

    @Autowired
    private InstrumentRepository repository;

    @Autowired
    InstrumentCommissionRepository icRepository;

    public Instrument save(Instrument instrument) {
        log.info("Saving instrument : " + instrument.toString());
        Optional<Instrument> dbInstrument = repository.findByName(instrument.getName());
        if(!dbInstrument.isPresent())
        {
            log.info("DB Instrument is not present !! ");
            return repository.save(instrument);
        }
        return null;
    }

    public void clean() {
        repository.deleteAll();
    }
}
