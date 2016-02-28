package com.josemorenoesteban.zooplus.challenge.service.exchange.openexchangerates;

import java.util.Map;
import lombok.Data;

@Data
class LatestRates {
    private Long timestamp;
    private String base;
    private Map<String, Float> rates;
}
