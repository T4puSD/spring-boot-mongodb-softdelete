package com.tapusd.demomongoref.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Country.COLLECTION_NAME)
public class Country extends AbstractDocument {

    public static final String COLLECTION_NAME = "country";

    @Id
    // serializing to String instead of object during returning response to client
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    @Indexed(unique = true, partialFilter = "{isDeleted: false}")
    private String name;

    private String isoCode;

    private String isoCodeFull;

    private String dialCode;

    public ObjectId getId() {
        return id;
    }

    public Country setId(ObjectId id) {
        this.id = id;
        return this;
    }

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
