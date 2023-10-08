package com.ahirajustice.api.location.service.common.repositories;

import com.ahirajustice.api.location.service.common.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>, QuerydslPredicateExecutor<Country> {

    Optional<Country> findByCode(String code);

}
