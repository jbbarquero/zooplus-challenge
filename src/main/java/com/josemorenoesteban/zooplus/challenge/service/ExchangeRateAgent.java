package com.josemorenoesteban.zooplus.challenge.service;

import static com.josemorenoesteban.zooplus.challenge.service.GetExchangeRateResponse.Issue.*;

import java.util.Currency;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;
import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRateRepository;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateService;

@Component
public class ExchangeRateAgent {
    @Autowired private ExchangeRateService    exchangeService;
    @Autowired private ExchangeRateRepository exchangeRates;
    
    private static final int LAST_SIZE = 10;
    
    public GetExchangeRateResponse get(final String source, final String target) {
        GetExchangeRateResponse response = new GetExchangeRateResponse();
        
        response.setLatstSearches(lastQueries());
        currentExchangeRate(response, source, target);
        if (response.issue==NO_ISSUE) {
            response.getCurrent().setRequestTimestamp(System.currentTimeMillis());
            exchangeRates.save(response.getCurrent());
        }
        return response;
    }

    public List<ExchangeRate> lastQueries() {
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
    
    private void currentExchangeRate(final GetExchangeRateResponse response, final String source, 
                                     final String target) {
        ExchangeRate exchangeRate;
        try {
            exchangeRate = exchangeService.get(source, target);
        } catch(Throwable t) {
            // Implementación de un cortocircuito cuando falle la recuperación del servicio
            // TODO Aquí se ha producido un error al llamar y se debería recuperar del repositorio 
            //      el últimmo que se tenga para el source y el target recibido por parámetro.
            //      se debería añadir el método al repositorio.
            Long now = System.currentTimeMillis();
            exchangeRate = new ExchangeRate();
            exchangeRate.setSource(source);
            exchangeRate.setTarget(target);
            exchangeRate.setRateTimestamp(now);
            exchangeRate.setRate(-1F);
            
            response.setIssue(NO_CONNECTION_TO_SERVER);
        }
        response.setCurrent(exchangeRate);
    }
}
