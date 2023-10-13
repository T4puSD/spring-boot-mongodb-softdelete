package com.tapusd.demomongoref.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.tapusd.demomongoref.domain.enums.Status;
import org.bson.types.ObjectId;

import java.time.Instant;

public record CountryResponseDTO(@JsonSerialize(using = ToStringSerializer.class) ObjectId id,
                                 String name,
                                 String isoCode,
                                 String isoCodeFull,
                                 Status status,
                                 Instant createdAt,
                                 Instant updatedAt) {
}
