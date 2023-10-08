package com.tapusd.demomongoref.mapper;

import com.tapusd.demomongoref.domain.Country;
import com.tapusd.demomongoref.dto.request.CountryRequestDTO;
import com.tapusd.demomongoref.dto.response.CountryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country toCountry(CountryRequestDTO dto);
    CountryResponseDTO toResponseDTO(Country country);
}
