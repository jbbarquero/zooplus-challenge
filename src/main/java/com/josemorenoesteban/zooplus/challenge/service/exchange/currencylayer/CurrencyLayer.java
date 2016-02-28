package com.josemorenoesteban.zooplus.challenge.service.exchange.currencylayer;

import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;
import com.josemorenoesteban.zooplus.challenge.service.exchange.ExchangeService;
import java.util.Currency;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

public class CurrencyLayer implements ExchangeService {
    public static final String ACCESS_KEY = "26c8728f9012877c925f60c9714232f1";
    
    private static final String LIVE = "http://apilayer.net/api/live?access_key={access_key}&source={source}";

    private final RestTemplate restTemplate = new RestTemplate();

    /*
    Response: 
    
    {
    "success": true,
    "terms": "https://currencylayer.com/terms",
    "privacy": "https://currencylayer.com/privacy",
    "timestamp": ​1456598715,
    "source": "USD",
    "quotes": 
        {
            "USDEUR": ​0.914746,
            "USDGBP": ​0.720851
        }
    }
    */
    
    @Override
    public Exchange latest() {
        LiveResponse liveResponse = restTemplate.getForObject(LIVE, LiveResponse.class, ACCESS_KEY, "USD");
      
        Exchange exchange = new Exchange();
        exchange.setBase(Currency.getInstance(liveResponse.getSource()));
        exchange.setTimestamp(liveResponse.getTimestamp());
        
        System.out.printf("total quotes (before)=%s\n",liveResponse.getQuotes().size());
        
        
        exchange.setRates(liveResponse.getQuotes().entrySet().stream()
            .filter(e -> existCurrency(e.getKey()))
            .map(e-> {
                Exchange.Rate rate = new Exchange.Rate();
                rate.setCurrency(Currency.getInstance(e.getKey()));
                rate.setExchange(e.getValue());
                return rate;
            }).collect(Collectors.toList()) );
        return exchange;
    }
}
