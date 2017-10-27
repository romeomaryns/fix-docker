package eu.maryns.fix.source.candles.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class CandleNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public CandleNotFoundException(String candle) {
        super("No such candle: " + candle);
    }

}