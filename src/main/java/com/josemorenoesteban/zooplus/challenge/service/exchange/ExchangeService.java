package com.josemorenoesteban.zooplus.challenge.service.exchange;

import java.util.Currency;

public interface ExchangeService {
    Exchange latest();
    
    default boolean existCurrency(final String currencyCode) {
        try { 
            Currency.getInstance(currencyCode);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }
}
