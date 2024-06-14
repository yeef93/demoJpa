package com.yeef93.demoJpa.currency.repository;

import com.yeef93.demoJpa.currency.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository  extends JpaRepository<Currency, Integer> {
    Currency findByName(String name);
}

