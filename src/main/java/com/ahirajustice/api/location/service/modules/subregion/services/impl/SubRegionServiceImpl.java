package com.ahirajustice.api.location.service.modules.subregion.services.impl;

import com.ahirajustice.api.location.service.common.entities.SubRegion;
import com.ahirajustice.api.location.service.common.exceptions.NotFoundException;
import com.ahirajustice.api.location.service.common.repositories.SubRegionRepository;
import com.ahirajustice.api.location.service.modules.subregion.queries.SearchSubRegionsQuery;
import com.ahirajustice.api.location.service.modules.subregion.services.SubRegionService;
import com.ahirajustice.api.location.service.modules.subregion.viewmodels.SubRegionDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubRegionServiceImpl implements SubRegionService {

    private final SubRegionRepository subRegionRepository;

    @Override
    public Page<SubRegionDetails> searchSubRegions(SearchSubRegionsQuery query) {
        return subRegionRepository.findAll(query.getPredicate(), query.getPageable()).map(SubRegionDetails::from);
    }

    @Override
    public SubRegionDetails getSubRegion(String code) {
        SubRegion subRegion = validateSubRegion(code);
        return SubRegionDetails.from(subRegion);
    }

    private SubRegion validateSubRegion(String code) {
        SubRegion subRegion = subRegionRepository.findByCode(code).orElse(null);

        if (subRegion == null)
            throw new NotFoundException(String.format("Sub-region with code: '%s' does not exist", code));

        return subRegion;
    }

}
