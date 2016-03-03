package com.josemorenoesteban.zooplus.challenge.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;
import java.util.ArrayList;

@Data @NoArgsConstructor @AllArgsConstructor
public class GetExchangeRateResponse {
    public enum Issue { NO_CONNECTION_TO_SERVER };
    
    public List<ExchangeRate> latstSearches;
    public ExchangeRate       current;
    public List<Issue>        issues = new ArrayList();
    
    public boolean hasIssues() { 
        return !issues.isEmpty(); 
    }

    public boolean hasIssue(final Issue issue) { 
        return issues.contains(issue); 
    }
}
