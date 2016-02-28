package com.josemorenoesteban.zooplus.challenge.service.exchange.currencylayer;

import java.util.Map;
import lombok.Data;

@Data
class LiveResponse {
    private Long               timestamp;
    private String             source;
    private Map<String, Float> quotes;
}
