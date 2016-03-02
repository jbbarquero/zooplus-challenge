package com.josemorenoesteban.zooplus.challenge.service;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;
import java.util.Currency;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRateRepository;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateService;

public class ExchangeRateAgent {
    @Autowired private ExchangeRateService    exchangeService;
    @Autowired private ExchangeRateRepository exchangeRates;
    
    private static final int HISTORIC_SIZE = 10;
    
    public void get(final String source, final String target) {
       List<ExchangeRate> rates        = getLast(HISTORIC_SIZE);
       ExchangeRate       exchangeRate = exchangeService.get("USD", target);
    }
    
    public Set<Currency> currencies() {
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
    
    private List<ExchangeRate> getLast(int size) {
        final Pageable lastExchanges = new PageRequest(0, size, Sort.Direction.DESC, "requestTimestamp"); 
        return exchangeRates.findAll(lastExchanges).getContent();
    }
}
