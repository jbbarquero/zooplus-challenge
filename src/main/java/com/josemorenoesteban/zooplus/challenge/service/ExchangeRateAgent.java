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
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateAgent {
    @Autowired private ExchangeRateService    exchangeService;
    @Autowired private ExchangeRateRepository exchangeRates;
    
    private static final int LAST_SIZE = 10;
    
    public GetExchangeRateResponse get(final String source, final String target) {
       List<ExchangeRate> rates        = last();
       ExchangeRate       exchangeRate = exchangeService.get("USD", target);
       exchangeRate.setRequestTimestamp(System.currentTimeMillis());
       exchangeRates.save(exchangeRate);
       
       return new GetExchangeRateResponse (rates, exchangeRate);
    }

    public List<ExchangeRate> last() {
        final Pageable lastExchanges = new PageRequest(0, LAST_SIZE, Sort.Direction.DESC, "requestTimestamp"); 
        return exchangeRates.findAll(lastExchanges).getContent();
    }
    
    public Set<Currency> currencies() {
        //https://currencylayer.com/downloads/cl-currencies-table.txt
        final Set<Currency> currencies = new LinkedHashSet() {{
            add(Currency.getInstance("EUR"));   // Euro
            //add(Currency.getInstance("USD"));
            add(Currency.getInstance("GBP"));   // LIbra
            add(Currency.getInstance("NZD"));   // Nez Zenland Dollar
            add(Currency.getInstance("AUD"));   // autralian Dollar
            add(Currency.getInstance("JPY"));   // Japan Yen
            add(Currency.getInstance("HUF"));   // Hungarian Forint
            add(Currency.getInstance("ARS"));   // Argentine Peso
            add(Currency.getInstance("BAM"));   // Bosnia-Herzegovina Convertible Mark
            add(Currency.getInstance("BGN"));   // Bulgarian Lev
            add(Currency.getInstance("BRL"));   // Brazilian Real
            add(Currency.getInstance("CAD"));   // Canadian Dollar
            add(Currency.getInstance("CHF"));   // Swiss Franc
            add(Currency.getInstance("CNY"));   // Chinese Yuan
            add(Currency.getInstance("CZK"));   // Czech Republic Korun
        }};
        return currencies;
    }
    
    
}
