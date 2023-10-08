package com.ahirajustice.api.location.service.common.repositories;

import com.ahirajustice.api.location.service.common.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>, QuerydslPredicateExecutor<Region> {

    Optional<Region> findByCode(String code);
    List<Region> findByCountryCode(String countryCode);

}
