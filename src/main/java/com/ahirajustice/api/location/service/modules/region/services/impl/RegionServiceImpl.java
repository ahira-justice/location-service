package com.ahirajustice.api.location.service.modules.region.services.impl;

import com.ahirajustice.api.location.service.common.entities.Region;
import com.ahirajustice.api.location.service.common.entities.SubRegion;
import com.ahirajustice.api.location.service.common.exceptions.NotFoundException;
import com.ahirajustice.api.location.service.common.repositories.RegionRepository;
import com.ahirajustice.api.location.service.common.repositories.SubRegionRepository;
import com.ahirajustice.api.location.service.modules.region.queries.SearchRegionsQuery;
import com.ahirajustice.api.location.service.modules.region.services.RegionService;
import com.ahirajustice.api.location.service.modules.region.viewmodels.RegionDetails;
import com.ahirajustice.api.location.service.modules.subregion.viewmodels.SubRegionViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final SubRegionRepository subRegionRepository;

    @Override
    public Page<RegionDetails> searchRegions(SearchRegionsQuery query) {
        return regionRepository.findAll(query.getPredicate(), query.getPageable()).map(RegionDetails::from);
    }

    @Override
    public RegionDetails getRegion(String code) {
        Region region = validateRegion(code);
        return RegionDetails.from(region);
    }

    private Region validateRegion(String code) {
        Region region = regionRepository.findByCode(code).orElse(null);

        if (region == null)
            throw new NotFoundException(String.format("Region with code: '%s' does not exist", code));

        return region;
    }

    @Override
    public List<SubRegionViewModel> getRegionSubRegions(String code) {
        List<SubRegion> regionSubRegions = subRegionRepository.findByRegionCode(code);
        return regionSubRegions.stream().map(SubRegionViewModel::from).collect(Collectors.toList());
    }

}
