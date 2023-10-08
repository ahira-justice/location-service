package com.ahirajustice.api.location.service.modules.region.viewmodels;

import com.ahirajustice.api.location.service.common.entities.Region;
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
public class RegionDetails extends BaseViewModel {

    private String code;
    private String name;
    private String alias;
    private String countryCode;
    private String countryName;

    public static RegionDetails from(Region region) {
        RegionDetails response = new RegionDetails();

        BeanUtils.copyProperties(region, response);
        response.setCountryCode(region.getCountry().getCode());
        response.setCountryName(region.getCountry().getName());

        return response;
    }

}
