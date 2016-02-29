package com.josemorenoesteban.zooplus.challenge.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Data;

@Entity
@Data
public class Conversion implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;    
    
    private String source;
    private String target;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   rateDate;
    private Float  rate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Long   requestTimestamp;   
}
