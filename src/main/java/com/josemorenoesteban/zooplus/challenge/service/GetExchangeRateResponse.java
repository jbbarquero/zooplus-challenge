package com.josemorenoesteban.zooplus.challenge.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;

@Data @NoArgsConstructor @AllArgsConstructor
public class GetExchangeRateResponse {
    public List<ExchangeRate> latstSearches;
    public ExchangeRate       current;
    public Issue              issue = Issue.NO_ISSUE;
    
    public static enum Issue {
        NO_ISSUE(""),
        NO_CONNECTION_TO_SERVER("Communication error with exchange rate server");
        
        private final String message;
        
        Issue(String message){
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
