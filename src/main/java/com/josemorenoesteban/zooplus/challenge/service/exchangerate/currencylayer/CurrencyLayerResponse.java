package com.josemorenoesteban.zooplus.challenge.service.exchangerate.currencylayer;

import java.util.Map;
import lombok.Data;

@Data
public class CurrencyLayerResponse {
    private Long               timestamp;
    private String             source;
    private Map<String, Float> quotes;
    private String             date;
}
