package com.ahirajustice.api.location.service.modules.region.controllers;

import com.ahirajustice.api.location.service.modules.region.queries.SearchRegionsQuery;
import com.ahirajustice.api.location.service.modules.region.services.RegionService;
import com.ahirajustice.api.location.service.modules.region.viewmodels.RegionDetails;
import com.ahirajustice.api.location.service.modules.subregion.viewmodels.SubRegionViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<RegionDetails> searchRegions(@Valid SearchRegionsQuery query) {
        return regionService.searchRegions(query);
    }

    @RequestMapping(path = "/{code}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RegionDetails getRegion(@PathVariable String code) {
        return regionService.getRegion(code);
    }

    @RequestMapping(path = "/{code}/sub-regions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<SubRegionViewModel> getRegionSubRegions(@PathVariable String code) {
        return regionService.getRegionSubRegions(code);
    }

}
