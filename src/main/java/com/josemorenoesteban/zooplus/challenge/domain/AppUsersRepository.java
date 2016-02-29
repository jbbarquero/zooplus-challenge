package com.josemorenoesteban.zooplus.challenge.domain;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface AppUsersRepository extends Repository<AppUser, String> {
    List<AppUser> findTop10ByLastname(String lastname);
}
