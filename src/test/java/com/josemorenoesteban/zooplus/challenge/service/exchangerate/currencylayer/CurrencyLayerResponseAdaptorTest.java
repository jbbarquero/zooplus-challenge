package com.josemorenoesteban.zooplus.challenge.service.exchangerate.currencylayer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;

public class CurrencyLayerResponseAdaptorTest {
    private CurrencyLayerResponseAdaptor adaptor; // the SUT
    
    @Before
    public void setup() {
        adaptor = new CurrencyLayerResponseAdaptor();
    }
    
    @Test public void canAdaptTestRequest() {
        CurrencyLayerResponse response = createResponse("USD", "USDEUR", 0.897183F, null, 1455667199L);
        
        ExchangeRate rate = adaptor.adapt(response);
        
        assertNotNull(rate);
        assertEquals("USD",       rate.getSource());
        assertEquals("EUR",       rate.getTarget());
        assertEquals(0.897183F,   rate.getRate(), 0.0);
        assertEquals(1455667199L, rate.getRateTimestamp(), 0);
        assertNull(rate.getRateDate());
    }
    
    @Test public void canAdaptHistoricalRequest() {
        CurrencyLayerResponse response = createResponse("USD", "USDEUR", 0.897183F, "2016-02-16", 1455667199L);
        
        ExchangeRate rate = adaptor.adapt(response);
        
        assertNotNull(rate);
        assertEquals("USD",        rate.getSource());
        assertEquals("EUR",        rate.getTarget());
        assertEquals(0.897183F,    rate.getRate(), 0.0);
        assertEquals("2016-02-16", rate.getRateDate());
        assertEquals(1455667199L,  rate.getRateTimestamp(), 0);
    }
    
    private CurrencyLayerResponse createResponse(final String source, final String target, 
                                                 final Float rate, String date, Long timestamp) {
        CurrencyLayerResponse response = new CurrencyLayerResponse();
        response.setSource(source);
        response.setTimestamp(timestamp);
        response.setDate(date);
        response.setQuotes( new HashMap<String, Float>() {{ put(target, rate); }} );
        return response;
    }
}
