package com.josemorenoesteban.zooplus.challenge.service.exchangerate.currencylayer;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateAdaptor;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateService;

@Component
public class CurrencyLayerExchangeService implements ExchangeRateService {
    private static final String ACCESS_KEY = "26c8728f9012877c925f60c9714232f1";

    private static final String LIVE       = "http://apilayer.net/api/live?access_key={access_key}&currencies={target}";
    private static final String HISTORICAL = "http://apilayer.net/api/historical?access_key={access_key}&date={date}&currencies={target}";

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired ExchangeRateAdaptor adaptor;
    
    @Override
    public ExchangeRate get(final String source, final String target) {
        CurrencyLayerResponse response = restTemplate.getForObject(LIVE, CurrencyLayerResponse.class, ACCESS_KEY, target);
        return adaptor.adapt(response);
    }

    @Override
    public ExchangeRate get(final String source, final String target, final String rateDate) {
        CurrencyLayerResponse response = restTemplate.getForObject(HISTORICAL, CurrencyLayerResponse.class, ACCESS_KEY, rateDate, target);
        return adaptor.adapt(response);
    }
}
