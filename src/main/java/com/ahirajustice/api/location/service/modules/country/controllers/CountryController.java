package com.ahirajustice.api.location.service.modules.country.controllers;

import com.ahirajustice.api.location.service.modules.country.queries.SearchCountriesQuery;
import com.ahirajustice.api.location.service.modules.country.services.CountryService;
import com.ahirajustice.api.location.service.modules.country.viewmodels.CountryViewModel;
import com.ahirajustice.api.location.service.modules.region.viewmodels.RegionViewModel;
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
@RequestMapping("api/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<CountryViewModel> searchCountries(@Valid SearchCountriesQuery query) {
        return countryService.searchCountries(query);
    }

    @RequestMapping(path = "/{code}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public CountryViewModel getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @RequestMapping(path = "/{code}/regions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RegionViewModel> getCountryRegions(@PathVariable String code) {
        return countryService.getCountryRegions(code);
    }

}
