package com.ahirajustice.api.location.service.modules.region.services;

import com.ahirajustice.api.location.service.modules.region.queries.SearchRegionsQuery;
import com.ahirajustice.api.location.service.modules.region.viewmodels.RegionDetails;
import com.ahirajustice.api.location.service.modules.subregion.viewmodels.SubRegionViewModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RegionService {

    Page<RegionDetails> searchRegions(SearchRegionsQuery query);
    RegionDetails getRegion(String code);
    List<SubRegionViewModel> getRegionSubRegions(String code);

}
