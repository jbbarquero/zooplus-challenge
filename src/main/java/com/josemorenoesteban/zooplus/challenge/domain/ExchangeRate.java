package com.josemorenoesteban.zooplus.challenge.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity @IdClass(ExchangeRate.ExchangeRateRequest.class)
public class ExchangeRate implements Serializable {
    @Id @Column(name = "SOURCE", nullable = false) @NotNull @Size(max=3) 
    private String source;
    @Id @Column(name = "TARGET", nullable = false) @NotNull @Size(max=3) 
    private String target;
    @Id @Column(name = "REQUEST_TIMESTAMP", nullable = false) @NotNull
    private Long requestTimestamp;
    @Column(name = "RATE", nullable = false)
    private Double rate;
    @Column(name = "RATE_DATE", nullable = true) @Size(max=10) 
    private String rateDate;        
    
    @Data @NoArgsConstructor @AllArgsConstructor 
    public static class ExchangeRateRequest implements Serializable {
        private String source;
        private String target;
        private Long   requestTimestamp;
    }
}
