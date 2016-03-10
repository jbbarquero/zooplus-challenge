package com.josemorenoesteban.zooplus.challenge.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class Users implements Serializable, UserDetails {

    @Id
    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    @Column(name = "enabled", nullable = false)
    @NotNull
    private boolean enabled;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String birthday;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("USER", "SUPERUSER", "ROLE_SUPERUSER");
        // return Arrays.asList(new SimpleGrantedAuthority("USER"),
        // new SimpleGrantedAuthority("SUPERUSER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
