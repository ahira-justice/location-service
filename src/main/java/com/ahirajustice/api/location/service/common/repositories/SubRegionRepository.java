package com.ahirajustice.api.location.service.common.repositories;

import com.ahirajustice.api.location.service.common.entities.SubRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubRegionRepository extends JpaRepository<SubRegion, Long>, QuerydslPredicateExecutor<SubRegion> {

    Optional<SubRegion> findByCode(String code);
    List<SubRegion> findByRegionCode(String regionCode);

}
