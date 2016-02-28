package com.josemorenoesteban.zooplus.challenge.service.exchange.mock;

import com.josemorenoesteban.zooplus.challenge.service.exchange.openexchangerates.*;
import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;
import com.josemorenoesteban.zooplus.challenge.service.exchange.ExchangeService;
import java.time.Instant;
import java.util.Currency;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

public class MockExchangeService implements ExchangeService {

    /**
     * Get the latest exchange rates available from the Open Exchange Rates API.
     *
     * @return map with latest rates
     *
     * @see https://docs.openexchangerates.org/docs/latest-json
     */
    @Override
    public Exchange latest() {

        Exchange exchange = new Exchange();
        exchange.setBase(Currency.getInstance("USD"));
        exchange.setTimestamp(Instant.now().toEpochMilli());
//        exchange.setRates(latestRates.getRates().entrySet().stream()
//            .filter(e -> existCurrency(e.getKey()))
//            .map(e -> {
//                Exchange.Rate rate = new Exchange.Rate();
//                rate.setCurrency(Currency.getInstance(e.getKey()));
//                rate.setExchange(e.getValue());
//                return rate;
//            }).collect(Collectors.toList()));
        return exchange;
    }

}
