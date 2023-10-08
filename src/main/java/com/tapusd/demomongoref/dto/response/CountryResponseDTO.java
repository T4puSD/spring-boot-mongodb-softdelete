package com.tapusd.demomongoref.dto.response;

import com.tapusd.demomongoref.domain.enums.Status;

import java.time.Instant;

public record CountryResponseDTO(String id,
                                 String name,
                                 String isoCode,
                                 String isoCodeFull,
                                 Status status,
                                 Instant createdAt,
                                 Instant updatedAt) {
}
