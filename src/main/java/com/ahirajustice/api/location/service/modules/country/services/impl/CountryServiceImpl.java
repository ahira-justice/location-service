package com.ahirajustice.api.location.service.modules.country.services.impl;

import com.ahirajustice.api.location.service.common.entities.Country;
import com.ahirajustice.api.location.service.common.entities.Region;
import com.ahirajustice.api.location.service.common.exceptions.NotFoundException;
import com.ahirajustice.api.location.service.common.repositories.CountryRepository;
import com.ahirajustice.api.location.service.common.repositories.RegionRepository;
import com.ahirajustice.api.location.service.modules.country.queries.SearchCountriesQuery;
import com.ahirajustice.api.location.service.modules.country.services.CountryService;
import com.ahirajustice.api.location.service.modules.country.viewmodels.CountryViewModel;
import com.ahirajustice.api.location.service.modules.region.viewmodels.RegionViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;

    @Override
    public Page<CountryViewModel> searchCountries(SearchCountriesQuery query) {
        return countryRepository.findAll(query.getPredicate(), query.getPageable()).map(CountryViewModel::from);
    }

    @Override
    public CountryViewModel getCountry(String code) {
        Country country = validateCountry(code);
        return CountryViewModel.from(country);
    }

    private Country validateCountry(String code) {
        Country country = countryRepository.findByCode(code).orElse(null);

        if (country == null)
            throw new NotFoundException(String.format("Country with code: '%s' does not exist", code));

        return country;
    }

    @Override
    public List<RegionViewModel> getCountryRegions(String code) {
        List<Region> countryRegions = regionRepository.findByCountryCode(code);
        return countryRegions.stream().map(RegionViewModel::from).collect(Collectors.toList());
    }

}
