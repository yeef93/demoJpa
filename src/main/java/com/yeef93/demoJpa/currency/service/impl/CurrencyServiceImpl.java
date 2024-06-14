package com.yeef93.demoJpa.currency.service.impl;

import com.yeef93.demoJpa.currency.entity.Currency;
import com.yeef93.demoJpa.currency.repository.CurrencyRepository;
import com.yeef93.demoJpa.currency.service.CurrencyService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Currency> findAll() {
        return  currencyRepository.findAll();
    }
}
