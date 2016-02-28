package com.josemorenoesteban.zooplus.challenge.service.exchange.openexchangerates;

import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;
import com.josemorenoesteban.zooplus.challenge.service.exchange.ExchangeService;
import java.util.Currency;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

public class OpenExchangeRates implements ExchangeService {

    public static final String APP_KEY = "55ca7a4ee06146e4b46ab28c106cf8c1";

    private static final String LATEST = "https://openexchangerates.org/api/latest.json?app_id={app_key}";
    private static final String CURRENCIES = "https://openexchangerates.org/api/currencies.json?app_id={app_key}";

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Get the latest exchange rates available from the Open Exchange Rates API.
     *
     * @return map with latest rates
     *
     * @see https://docs.openexchangerates.org/docs/latest-json
     */
    @Override
    public Exchange latest() {
        LatestRates latestRates = restTemplate.getForObject(LATEST, LatestRates.class, APP_KEY);

        Exchange exchange = new Exchange();
        exchange.setBase(Currency.getInstance(latestRates.getBase()));
        exchange.setTimestamp(latestRates.getTimestamp());
        exchange.setRates(latestRates.getRates().entrySet().stream()
            .filter(e -> existCurrency(e.getKey()))
            .map(e -> {
                Exchange.Rate rate = new Exchange.Rate();
                rate.setCurrency(Currency.getInstance(e.getKey()));
                rate.setExchange(e.getValue());
                return rate;
            }).collect(Collectors.toList()));
        return exchange;
    }

    public Map<String, String> currencies() {
        return restTemplate.getForObject(CURRENCIES, Map.class, APP_KEY);
    }

}
