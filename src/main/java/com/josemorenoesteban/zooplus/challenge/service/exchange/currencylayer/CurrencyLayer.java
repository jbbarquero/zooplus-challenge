package com.josemorenoesteban.zooplus.challenge.service.exchange.currencylayer;

import java.util.Currency;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;

public class CurrencyLayer /*implements ExchangeService*/ {
    private static final String ACCESS_KEY = "26c8728f9012877c925f60c9714232f1";
    private static final String LIST       = "http://apilayer.net/api/list?access_key={access_key}";
    private static final String LIVE       = "http://apilayer.net/api/live?access_key={access_key}&currencies={target}";
    private static final String HISTORICAL = "http://apilayer.net/api/historical?access_key={access_key}&date={date}&currencies={currency}";

    private final RestTemplate restTemplate = new RestTemplate();

    public Exchange latest(String target) {
        LiveResponse liveResponse = restTemplate.getForObject(LIVE, LiveResponse.class, ACCESS_KEY, target);
      
        Exchange exchange = new Exchange();
        exchange.setBase(Currency.getInstance(liveResponse.getSource()));
        exchange.setTimestamp(liveResponse.getTimestamp());
        exchange.setRates(liveResponse.getQuotes().entrySet().stream()
            .filter(this::existCurrency)
            .map(this::adapt)
            .collect(Collectors.toList()) 
        );
        return exchange;
    }

    boolean existCurrency(final Map.Entry<String, Float> e) {
        try { 
            Currency.getInstance(e.getKey().substring(3));
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }
    
    private Exchange.Rate adapt(final Map.Entry<String, Float> e) {
        Exchange.Rate rate = new Exchange.Rate();
        rate.setCurrency(Currency.getInstance(e.getKey().substring(3)));
        rate.setExchange(e.getValue());
        return rate;
    } 
}
