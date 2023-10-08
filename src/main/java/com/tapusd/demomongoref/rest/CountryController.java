package com.tapusd.demomongoref.rest;

import com.tapusd.demomongoref.domain.Country;
import com.tapusd.demomongoref.dto.request.CountryRequestDTO;
import com.tapusd.demomongoref.dto.response.CountryResponseDTO;
import com.tapusd.demomongoref.exception.NotFoundException;
import com.tapusd.demomongoref.mapper.CountryMapper;
import com.tapusd.demomongoref.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> findById(@PathVariable String id) {
        return countryRepository.findById(id);
    }

    @PostMapping("/{id}")
    public CountryResponseDTO update(@PathVariable String id, @RequestBody CountryRequestDTO dto) {
        var country = countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country not found with provided id"));

        if (StringUtils.hasText(dto.name())) {
            country.setName(dto.name());
        }
        if (StringUtils.hasText(dto.isoCode())) {
            country.setIsoCode(dto.isoCode());
        }
        if (StringUtils.hasText(dto.isoCodeFull())) {
            country.setIsoCodeFull(dto.isoCodeFull());
        }

        Country save = countryRepository.save(country);
        return CountryMapper.INSTANCE.toResponseDTO(save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable String id) {
        countryRepository.deleteById(id);
    }
}
