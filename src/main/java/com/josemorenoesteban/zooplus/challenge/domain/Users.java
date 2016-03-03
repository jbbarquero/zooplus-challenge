package com.josemorenoesteban.zooplus.challenge.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity 
public class Users implements Serializable {
    @Id @Column(name="email", nullable=false) @NotNull
    private String email;
    
    @Column(name="password", nullable=false) @NotNull
    private String password;

    @Column(name="enabled", nullable=false) @NotNull
    private Boolean enabled;
}
