package com.josemorenoesteban.zooplus.challenge.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, ExchangeRate.ExchangeRateRequest> {
}
