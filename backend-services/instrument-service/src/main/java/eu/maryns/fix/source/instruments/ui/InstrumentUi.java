package eu.maryns.fix.source.instruments.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@SpringUI
@Theme("valo")
public class InstrumentUi extends UI{

    private final InstrumentRepository repo;
    private final InstrumentEditor editor;
    private final Grid<Instrument> grid;
    final TextField filter;

    private final Button addNewBtn;

    @Autowired
    public InstrumentUi(InstrumentRepository repo, InstrumentEditor editor) {
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid<>(Instrument.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New Instrument", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);
        grid.setWidth(100,Unit.PERCENTAGE);
     //   grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id",
                "name",
                "type",
                "displayName",
                "pipLocation",
                "displayPrecision",
                "tradeUnitsPrecision",
                "minimumTradeSize",
                "maximumTrailingStopDistance",
                "minimumTrailingStopDistance",
                "maximumPositionSize",
                "maximumOrderUnits",
                "marginRate");

        filter.setPlaceholder("Filter by displayName");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> listInstruments(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editInstrument(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> editor.editInstrument(new Instrument()));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listInstruments(filter.getValue());
        });

        // Initialize listing
        listInstruments(null);
    }

    private void listInstruments() {
        grid.setItems((List<Instrument>) repo.findAll());
    }

    void listInstruments(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems((List<Instrument>) repo.findAll());
        }
        else {
            grid.setItems(repo.findByDisplayNameStartsWithIgnoreCase(filterText));
        }
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = InstrumentUi.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
