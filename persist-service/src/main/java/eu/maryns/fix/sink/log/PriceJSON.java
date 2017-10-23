package eu.maryns.fix.sink.log;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceJSON {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private String type;
    private String instrument;
    private String time;
    private String status;
    private Boolean tradeable;
    private ArrayList<String> bids;
    private ArrayList<String> asks;

    private String closeoutBid;
    private String closeoutAsk;
    private String quoteHomeConversionFactors;
    private String unitsAvailable;

}
/*
[{
    "type":"PRICE",
        "instrument":{},
        "time":{},
        "status":null,
        "tradeable":false,
        "bids":[{
            "price":{},
            "liquidity":10000000}]
        ,"asks":[{
            "price":{},
            "liquidity":10000000}],
        "closeoutBid":{},
        "closeoutAsk":{},
        "quoteHomeConversionFactors":{
                    "positiveUnits":{},
                    "negativeUnits":{}},
        "unitsAvailable":{
                    "reduceFirst":{
                            "short":{},
                            "long":{}},
                    "reduceOnly":{
                            "short":{},
                            "long":{}},
                    "openOnly":{
                            "short":{},
                            "long":{}},
                    "default":{
                            "short":{},
                            "long":{}}
        }},
        ]
        */