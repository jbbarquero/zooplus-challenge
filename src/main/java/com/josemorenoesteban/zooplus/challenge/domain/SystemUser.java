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
public class SystemUser implements Serializable {
    @Id @Column(name="EMAIL", nullable=false) @NotNull
    private String email;
    
    @Column(name="PASSWORD", nullable=false) @NotNull
    private String password;
}
