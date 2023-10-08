package com.ahirajustice.api.location.service.modules.country.services;

import com.ahirajustice.api.location.service.modules.country.queries.SearchCountriesQuery;
import com.ahirajustice.api.location.service.modules.country.viewmodels.CountryViewModel;
import com.ahirajustice.api.location.service.modules.region.viewmodels.RegionViewModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CountryService {

    Page<CountryViewModel> searchCountries(SearchCountriesQuery query);
    CountryViewModel getCountry(String code);
    List<RegionViewModel> getCountryRegions(String code);

}
