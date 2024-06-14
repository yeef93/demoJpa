package com.yeef93.demoJpa.currency.service;

import com.yeef93.demoJpa.currency.entity.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> findAll();
}
