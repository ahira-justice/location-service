package com.ahirajustice.api.location.service.modules.subregion.controllers;

import com.ahirajustice.api.location.service.modules.subregion.queries.SearchSubRegionsQuery;
import com.ahirajustice.api.location.service.modules.subregion.services.SubRegionService;
import com.ahirajustice.api.location.service.modules.subregion.viewmodels.SubRegionDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/sub-regions")
@RequiredArgsConstructor
public class SubRegionController {

    private final SubRegionService subRegionService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<SubRegionDetails> searchRegions(@Valid SearchSubRegionsQuery query) {
        return subRegionService.searchSubRegions(query);
    }

    @RequestMapping(path = "/{code}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SubRegionDetails getSubRegion(@PathVariable String code) {
        return subRegionService.getSubRegion(code);
    }

}
