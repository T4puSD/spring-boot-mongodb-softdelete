package com.tapusd.demomongoref.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Country.COLLECTION_NAME)
public class Country extends AbstractDocument {

    public static final String COLLECTION_NAME = "country";

    private String name;

    private String isoCode;

    private String isoCodeFull;

    private String dialCode;

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public Country setIsoCode(String isoCode) {
        this.isoCode = isoCode;
        return this;
    }

    public String getIsoCodeFull() {
        return isoCodeFull;
    }

    public Country setIsoCodeFull(String isoCodeFull) {
        this.isoCodeFull = isoCodeFull;
        return this;
    }

    public String getDialCode() {
        return dialCode;
    }

    public Country setDialCode(String dialCode) {
        this.dialCode = dialCode;
        return this;
    }
}
