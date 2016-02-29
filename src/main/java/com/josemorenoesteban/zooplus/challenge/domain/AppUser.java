package com.josemorenoesteban.zooplus.challenge.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import lombok.Data;

@Entity
@Data
public class AppUser {
    @Id
    private String email;
    
    private String firstname;
    private String lastname;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   birthday;
    // TODO Address info
    
    @OneToMany
    private List<Conversion> conversions;
}
