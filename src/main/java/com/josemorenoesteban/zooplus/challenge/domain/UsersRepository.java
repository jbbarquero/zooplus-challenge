package com.josemorenoesteban.zooplus.challenge.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
    default String encrypt(String password) {
        //return new BCryptPasswordEncoder().encode(password);
        return password;
    }
} 