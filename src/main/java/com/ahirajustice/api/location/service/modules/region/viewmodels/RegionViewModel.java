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
public class RegionViewModel extends BaseViewModel {

    private String code;
    private String name;
    private String alias;

    public static RegionViewModel from(Region region) {
        RegionViewModel response = new RegionViewModel();

        BeanUtils.copyProperties(region, response);

        return response;
    }

}
