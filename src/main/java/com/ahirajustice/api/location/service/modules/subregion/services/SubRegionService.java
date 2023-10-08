package com.ahirajustice.api.location.service.modules.subregion.services;

import com.ahirajustice.api.location.service.modules.subregion.queries.SearchSubRegionsQuery;
import com.ahirajustice.api.location.service.modules.subregion.viewmodels.SubRegionDetails;
import org.springframework.data.domain.Page;

public interface SubRegionService {

    Page<SubRegionDetails> searchSubRegions(SearchSubRegionsQuery query);
    SubRegionDetails getSubRegion(String code);

}
