package com.josemorenoesteban.zooplus.challenge.service.exchangerate;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;

public interface ExchangeRateAdaptor<T> {
    ExchangeRate adapt(T object);
    T adapt(ExchangeRate exchangeRate);
}
