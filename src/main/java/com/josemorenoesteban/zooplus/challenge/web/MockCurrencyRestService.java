package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements a mock of a currency exchange rate
 *
 * @author jmoreno
 */
@RestController("rate")
public class MockCurrencyRestService {
    private static final Float DEFAULT_RATE = 0.0f;
    private static final Map<String, Float> RATES = new HashMap() {{
        put("EUR", 1.0f);
        put("USD", 0.85f);
        put("GBP", 1.26f);
    }};
    
    @RequestMapping(method = GET)
    public Float rate(@RequestParam("currency") final String currency) {
        return  RATES.containsKey(currency) ? RATES.get(currency) : DEFAULT_RATE;
    } 
}
