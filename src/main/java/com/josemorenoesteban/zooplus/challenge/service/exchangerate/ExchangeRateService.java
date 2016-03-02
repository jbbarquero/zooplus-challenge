package com.josemorenoesteban.zooplus.challenge.service.exchangerate;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;

public interface ExchangeRateService {
    ExchangeRate get(final String source, final String target);
    ExchangeRate get(final String source, final String target, final String rateDate);
}
