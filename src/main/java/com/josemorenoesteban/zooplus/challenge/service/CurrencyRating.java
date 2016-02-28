package com.josemorenoesteban.zooplus.challenge.service;

import java.time.Instant;

public class CurrencyRating {
    private final String currency;
    private final Float  rating;
    private final Instant timestamp;
    
    public CurrencyRating(final String currency, final Float  rating) {
        this.currency = currency;
        this.rating   = rating;
        this.timestamp = Instant.now();
    }
    
    public String getCurrency() {
        return this.currency;
    }

    public Float getRating() {
        return this.rating;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }
}
