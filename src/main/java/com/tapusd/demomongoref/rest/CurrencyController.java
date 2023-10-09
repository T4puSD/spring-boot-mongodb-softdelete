package com.tapusd.demomongoref.rest;

import com.tapusd.demomongoref.domain.Currency;
import com.tapusd.demomongoref.repository.CurrencyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping
    public List<Currency> findAll() {
        List<Currency> all = currencyRepository.findAll();
        return all;
    }
}
