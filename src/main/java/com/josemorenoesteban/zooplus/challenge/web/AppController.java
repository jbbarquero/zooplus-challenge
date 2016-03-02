package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRateRepository;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateService;

@Controller
public class AppController {
    @Autowired private ExchangeRateService    exchangeService;
    @Autowired private ExchangeRateRepository exchangeRates;
    
    @RequestMapping(value="/", method=GET)
    public String home(final Model model) {
//        model.addAttribute("currencies", exchangeRates.currencies());

        return "index"; 
    }
    
    @RequestMapping(value="/rate", method=GET)
    public String rate(@RequestParam("target") final String target, 
                       final Model model) {
//        model.addAttribute("currencies",   exchangeRates.currencies());
//TODO        model.addAttribute("searchs",      exchangeRates.findTop10ByRequestTimestamp(Long.MIN_VALUE));
        model.addAttribute("exchangeRate", exchangeService.get("USD", target));
        
        return "index"; 
    }

    @RequestMapping(value="/signup", method=GET)
    public String signup(final Model model) {
        return "signup"; // se retorna el nombre de la vista lógica
    }
}
