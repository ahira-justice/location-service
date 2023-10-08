package com.ahirajustice.api.location.service.modules.country.viewmodels;

import com.ahirajustice.api.location.service.common.entities.Country;
import com.ahirajustice.api.location.service.common.viewmodels.BaseViewModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryViewModel extends BaseViewModel {

    private String code;
    private String name;

    public static CountryViewModel from(Country country) {
        CountryViewModel response = new CountryViewModel();

        BeanUtils.copyProperties(country, response);

        return response;
    }

}
