package com.josemorenoesteban.zooplus.challenge.service.exchange.openexchangerates;

import static org.junit.Assert.*;

import java.util.Currency;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;

public class OpenExchangeRatesIT {
    private OpenExchangeRates service;
    
    @Before public void setup() {
        service = new OpenExchangeRates();
    }

    @Test public void latest() {
        Exchange exchange = service.latest();
        assertNotNull(exchange);
        assertEquals(Currency.getInstance("USD"), exchange.getBase());
        assertNotNull(exchange.getRates());
    }

    @Test public void currrencies() {
        Map<String, String> currencies = service.currencies();
        assertNotNull(currencies);
    }
}
