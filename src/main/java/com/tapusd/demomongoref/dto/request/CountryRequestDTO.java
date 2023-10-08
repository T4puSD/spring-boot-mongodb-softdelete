package com.tapusd.demomongoref.dto.request;


public record CountryRequestDTO(String name,
                                String isoCode,
                                String isoCodeFull,
                                String dialCode) {
}
