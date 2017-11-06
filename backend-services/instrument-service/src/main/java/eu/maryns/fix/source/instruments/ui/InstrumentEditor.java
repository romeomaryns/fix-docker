package eu.maryns.fix.source.instruments.ui;

import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class InstrumentEditor extends VerticalLayout {

    private final InstrumentRepository repository;

    private Instrument instrument;

    /* Fields to edit properties in Instrument entity */
    TextField name = new TextField("Name");
    TextField type = new TextField("Type");
    TextField displayName = new TextField("displayName");
    TextField pipLocation = new TextField("pipLocation");
    TextField displayPrecision = new TextField("displayPrecision");
    TextField tradeUnitsPrecision = new TextField("tradeUnitsPrecision");
    TextField minimumTradeSize = new TextField("minimumTradeSize");
    TextField maximumTrailingStopDistance = new TextField("maximumTrailingStopDistance");
    TextField minimumTrailingStopDistance = new TextField("minimumTrailingStopDistance");
    TextField maximumPositionSize = new TextField("maximumPositionSize");
    TextField maximumOrderUnits = new TextField("maximumOrderUnits");
    TextField marginRate = new TextField("marginRate");


    /* Action buttons */
    Button save = new Button("Save", FontAwesome.SAVE);
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", FontAwesome.TRASH_O);
    CssLayout actions = new CssLayout(save, cancel, delete);

    Binder<Instrument> binder = new Binder<>(Instrument.class);

    @Autowired
    public InstrumentEditor(InstrumentRepository repository) {
        this.repository = repository;

        addComponents(name,
                type,
                displayName,
                pipLocation,
                displayPrecision,
                tradeUnitsPrecision,
                minimumTradeSize,
                maximumTrailingStopDistance,
                minimumTrailingStopDistance,
                maximumPositionSize,
                maximumOrderUnits,
                marginRate,
                actions);

        // bind using naming convention
// .withConverter(new LocalDateToDateConverter());
        //         .withConverter(new StringToDoubleConverter(

        StringToIntegerConverter integerConverter = new StringToIntegerConverter("Could not convert string to integer");
        StringToBigDecimalConverter bigdecimalConverter = new StringToBigDecimalConverter("Could not convert string to BigDecimal");
        binder.forMemberField(pipLocation)
                .withConverter(integerConverter);
        binder.forMemberField(displayPrecision)
                .withConverter(integerConverter);
        binder.forMemberField(tradeUnitsPrecision)
                .withConverter(integerConverter);
        binder.forMemberField(minimumTradeSize)
                .withConverter(bigdecimalConverter);
        binder.forMemberField(maximumTrailingStopDistance)
                .withConverter(bigdecimalConverter);
        binder.forMemberField(minimumTrailingStopDistance)
                .withConverter(bigdecimalConverter);
        binder.forMemberField(maximumPositionSize)
                .withConverter(bigdecimalConverter);
        binder.forMemberField(maximumOrderUnits)
                .withConverter(bigdecimalConverter);
        binder.forMemberField(marginRate)
                .withConverter(bigdecimalConverter);

        binder.bindInstanceFields(this);

        // Set the values of the bound fields to the values of your bean:
        binder.readBean(instrument);

        // Configure and style components
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> repository.save(instrument));
        delete.addClickListener(e -> repository.delete(instrument));
        cancel.addClickListener(e -> editInstrument(instrument));
        setVisible(false);
    }

    public interface ChangeHandler {

        void onChange();
    }

    public final void editInstrument(Instrument c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            instrument = repository.findById(c.getId()).get();
        }
        else {
            instrument = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(instrument);

        setVisible(true);

        // A hack to ensure the whole form is visible
        save.focus();
        // Select all text in firstName field automatically
        name.selectAll();
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        save.addClickListener(e -> h.onChange());
        delete.addClickListener(e -> h.onChange());
    }

}