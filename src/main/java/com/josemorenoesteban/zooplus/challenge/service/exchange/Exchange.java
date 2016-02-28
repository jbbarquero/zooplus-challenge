package com.josemorenoesteban.zooplus.challenge.service.exchange;

import java.util.Currency;
import java.util.List;
import lombok.Data;

@Data
public class Exchange {
    private Long       timestamp;
    private Currency   base;
    private List<Rate> rates;
    
    @Data
    public static class Rate {
        private Currency currency;
        public  Float    exchange;
    }
}
