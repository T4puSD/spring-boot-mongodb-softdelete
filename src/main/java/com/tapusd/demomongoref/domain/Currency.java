package com.tapusd.demomongoref.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
public class Currency extends AbstractDocument {

    public static final String COLLECTION_NAME = "currency";

    private String name;

    @Indexed(unique = true, partialFilter = "{isDeleted: false}")
    private String code;

    @DocumentReference(lazy = true)
    @Field(name = "countryIds")
    private List<Country> countries;

    public String getName() {
        return name;
    }

    public Currency setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Currency setCode(String code) {
        this.code = code;
        return this;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Currency setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }
}
