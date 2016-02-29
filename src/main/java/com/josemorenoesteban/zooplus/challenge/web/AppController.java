package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Currency;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josemorenoesteban.zooplus.challenge.service.exchange.Exchange;
import com.josemorenoesteban.zooplus.challenge.service.exchange.currencylayer.CurrencyLayer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.josemorenoesteban.zooplus.challenge.domain.AppUsersRepository;
import com.josemorenoesteban.zooplus.challenge.domain.ConversionRepository;

@Controller
public class AppController {
    @Autowired private AppUsersRepository   users;
    @Autowired private ConversionRepository conversions;
    
    @RequestMapping(value="/", method=GET)
    public String home(final Model model) {
        model.addAttribute("currencies", buildCurrenciesSet());
        model.addAttribute("rate",       createExchangeRate("USD", 1.1f));

        return "index"; 
    }
    
    @RequestMapping(value="/rate", method=GET)
    public String rate(@RequestParam("target") final String target, 
                       final Model model) {
        Exchange exchange = new CurrencyLayer().latest(target);
        
        model.addAttribute("currencies", buildCurrenciesSet());
        model.addAttribute("searchs",    getHistoricalSearchs());
        model.addAttribute("rate",       exchange.getRates().get(0));
        
        return "index"; 
    }

    @RequestMapping(value="/signup", method=GET)
    public String signup(final Model model) {
        return "signup"; // se retorna el nombre de la vista lógica
    }

   private Exchange createExchange(String source, String target, Float value) {
        Exchange exchange = new Exchange();
        exchange.setBase(Currency.getInstance(source));
        exchange.setTimestamp(System.currentTimeMillis());
        exchange.setRates( new ArrayList() {{ createExchangeRate(target, value);  }} );
        return exchange;
    }
   
    private Exchange.Rate createExchangeRate(String currency, Float value) {
        Exchange.Rate rate = new Exchange.Rate();
        rate.setCurrency(Currency.getInstance(currency));
        rate.setExchange(value);
        return rate;
    }

    private Set<Currency> buildCurrenciesSet() {
        final Set<Currency> currencies = new LinkedHashSet() {{
            add(Currency.getInstance("EUR"));
            //add(Currency.getInstance("USD"));
            add(Currency.getInstance("GBP"));
            add(Currency.getInstance("NZD"));
            add(Currency.getInstance("AUD"));
            add(Currency.getInstance("JPY"));
            add(Currency.getInstance("HUF"));
        }};
        return currencies;
    }
    
    private List<Exchange> getHistoricalSearchs() {
        return new LinkedList<Exchange>() {{
            add( createExchange("USD", "EUR", 1.1f) );
            add( createExchange("USD", "GBP", 1.2f) );
            add( createExchange("USD", "JPY", 1.4f) );
        }};
    }
}
