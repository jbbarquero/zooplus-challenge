package com.josemorenoesteban.zooplus.challenge.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MockRatingService implements RatingService {
    private static final String URL_TEMPLATE = "http://localhost:8080/rate?currency=%s";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public CurrencyRating getRating(final String currency) {
        Map<String, Float> params = new HashMap() {{
            put("currency", currency);
        }};
        
        Float  currencyRatting = restTemplate.getForObject(String.format(URL_TEMPLATE, currency), Float.class);
        return new CurrencyRating(currency, currencyRatting);
    }
}
