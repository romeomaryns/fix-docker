package eu.maryns.fix.source.instruments.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@SpringUI
@Theme("valo")
public class InstrumentUi extends UI{

    InstrumentRepository repo;
    Grid<Instrument> grid;

    @Autowired
    public InstrumentUi(InstrumentRepository repo) {
        this.repo = repo;
        this.grid = new Grid<>(Instrument.class);
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(grid);
        listInstruments();
    }

    private void listInstruments() {
        grid.setItems((List<Instrument>) repo.findAll());
    }

    void listInstruments(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems((List<Instrument>) repo.findAll());
        }
        else {
            grid.setItems(repo.findByDisplayName(filterText));
        }
    }
}
