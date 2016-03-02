package com.josemorenoesteban.zooplus.challenge.domain;

import java.util.Currency;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, ExchangeRate.ExchangeRateRequest> {
    
    default Set<Currency> currencies() {
        final Set<Currency> currencies = new LinkedHashSet() {{
            add(Currency.getInstance("EUR"));
            //add(Currency.getInstance("USD"));
            add(Currency.getInstance("GBP"));
            add(Currency.getInstance("NZD"));
            add(Currency.getInstance("AUD"));
            add(Currency.getInstance("JPY"));
            add(Currency.getInstance("HUF"));
        }};
        return currencies;
    }
}
