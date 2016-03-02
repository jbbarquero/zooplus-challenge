package com.josemorenoesteban.zooplus.challenge.service.exchangerate.currencylayer;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateAdaptor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CurrencyLayerResponseAdaptor implements ExchangeRateAdaptor<CurrencyLayerResponse> {
    @Override
    public ExchangeRate adapt(final CurrencyLayerResponse response) {
        if (response.getQuotes()!=null && response.getQuotes().size()==1) {
            Map.Entry<String, Float> exchangeRate = response.getQuotes().entrySet().iterator().next();
            String target = exchangeRate.getKey().substring(3); 
            Float  value  = exchangeRate.getValue();
            
            String dateDate = response.getDate() != null 
                            ? response.getDate() 
                            : LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
            
            ExchangeRate rate = new ExchangeRate();
            rate.setSource(response.getSource());
            rate.setRateTimestamp(response.getTimestamp());
            rate.setTarget(target);
            rate.setRate(value);
            rate.setRateDate(dateDate);

            return rate;
        } else {
            throw new RuntimeException("Message does not have quotes.");
        }
    }

    @Override
    public CurrencyLayerResponse adapt(ExchangeRate exchangeRate) {
        throw new UnsupportedOperationException("Not implemented."); //To change body of generated methods, choose Tools | Templates.
    }
}
