package com.josemorenoesteban.zooplus.challenge.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josemorenoesteban.zooplus.challenge.service.ExchangeRateAgent;
import com.josemorenoesteban.zooplus.challenge.service.GetExchangeRateResponse;
import com.josemorenoesteban.zooplus.challenge.service.UserAgent;

@Controller
public class AppController {
    public static final String DEFAULT_SOUCE = "USD";
    
    @Autowired private ExchangeRateAgent exchangeAgent;
    @Autowired private UserAgent         userAgent;
    
    @RequestMapping(value="/", method=GET)
    public String home(final Model model) {
        model.addAttribute("currencies", exchangeAgent.currencies());
        model.addAttribute("searchs",    exchangeAgent.lastQueries());

        return "index"; 
    }
    
    @RequestMapping(value="/rate", method=GET)
    public String rate(@RequestParam("target") final String target, 
                       final Model model) {
        GetExchangeRateResponse response = exchangeAgent.get(DEFAULT_SOUCE, target);
        
        model.addAttribute("currencies", exchangeAgent.currencies());
        model.addAttribute("searchs",    response.getLatstSearches());
        model.addAttribute("rate",       response.getCurrent());
        
        return "index"; 
    }

    @RequestMapping(value="/signin", method=GET)
    public String loginPage(@RequestParam(value="error", required=false) String error,
                            @RequestParam(value="logout",required=false) String logout,
                            final Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid Credentials provided.");
        }
 
        if (logout != null) {
            model.addAttribute("message", "Logged out from Challenge successfully.");
        }
        return "signin";
    }

    @RequestMapping(value="/signup", method=POST)
    public String signup(@RequestParam(value="firstname", required=false) String firstName,
                         @RequestParam(value="lastname",  required=false) String lastName,
                         @RequestParam(value="email",     required=false) String email,
                         @RequestParam(value="bday",      required=false) String bday,
                         @RequestParam(value="password",  required=false) String password,
                         final Model model) {
        
        System.out.printf(
                  "firstname=%s\n"
                + "lastname=%s\n"
                + "email=%s\n"
                + "bday=%s\n"
                + "password=%s\n\n", firstName, lastName, email, bday, password);
        
        return userAgent.signup(email, password) ? "index" : "signin";
    }

}
