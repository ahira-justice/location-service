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
public class SubRegionViewModel extends BaseViewModel {

    private String code;
    private String name;
    private String alias;

    public static SubRegionViewModel from(SubRegion subRegion) {
        SubRegionViewModel response = new SubRegionViewModel();

        BeanUtils.copyProperties(subRegion, response);

        return response;
    }

}
