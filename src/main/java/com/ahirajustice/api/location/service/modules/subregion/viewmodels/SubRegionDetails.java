package com.ahirajustice.api.location.service.modules.subregion.viewmodels;

import com.ahirajustice.api.location.service.common.entities.SubRegion;
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
public class SubRegionDetails extends BaseViewModel {

    private String code;
    private String name;
    private String alias;
    private String regionCode;
    private String regionName;

    public static SubRegionDetails from(SubRegion subRegion) {
        SubRegionDetails response = new SubRegionDetails();

        BeanUtils.copyProperties(subRegion, response);
        response.setRegionCode(subRegion.getRegion().getCode());
        response.setRegionName(subRegion.getRegion().getName());

        return response;
    }

}
