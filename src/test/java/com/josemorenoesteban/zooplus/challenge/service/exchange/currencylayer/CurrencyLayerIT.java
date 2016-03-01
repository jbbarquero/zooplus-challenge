package com.josemorenoesteban.zooplus.challenge.service.exchange.currencylayer;

import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;
import java.util.Currency;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyLayerIT {
    private CurrencyLayer service;
    
    @Before public void setup() {
        service = new CurrencyLayer();
    }

    @Test public void latest() {
        Exchange exchange = service.latest("EUR");
        assertNotNull(exchange);
        assertEquals(Currency.getInstance("USD"), exchange.getBase());
        assertNotNull(exchange.getRates());
    }
}
