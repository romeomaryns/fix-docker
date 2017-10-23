package eu.maryns.fix.source.instruments.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class InstrumentNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public InstrumentNotFoundException(String instrument) {
        super("No such account: " + instrument);
    }

}