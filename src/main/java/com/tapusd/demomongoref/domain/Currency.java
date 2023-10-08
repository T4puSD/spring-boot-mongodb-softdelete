package com.tapusd.demomongoref.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Currency extends AbstractDocument {

    public static final String COLLECTION_NAME = "currency";

    private String name;

    @Indexed(unique = true)
    private String code;

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
}
