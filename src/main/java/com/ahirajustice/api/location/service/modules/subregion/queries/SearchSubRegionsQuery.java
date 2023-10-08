package com.ahirajustice.api.location.service.modules.subregion.queries;

import com.ahirajustice.api.location.service.common.entities.BaseEntity;
import com.ahirajustice.api.location.service.common.entities.QSubRegion;
import com.ahirajustice.api.location.service.common.entities.SubRegion;
import com.ahirajustice.api.location.service.common.queries.BaseQuery;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchSubRegionsQuery extends BaseQuery {

    private String code;
    private String name;
    private String regionCode;
    private String regionName;

    @Override
    protected Class<? extends BaseEntity> getSortEntityClass() {
        return SubRegion.class;
    }

    @Override
    protected Predicate getPredicate(BooleanExpression expression) {
        if (StringUtils.isNotBlank(code)) {
            expression = expression.and(QSubRegion.subRegion.code.contains(code));
        }

        if (StringUtils.isNotBlank(name)) {
            expression = expression.and(QSubRegion.subRegion.name.contains(name));
        }

        if (StringUtils.isNotBlank(regionCode)) {
            expression = expression.and(QSubRegion.subRegion.region.code.contains(regionCode));
        }

        if (StringUtils.isNotBlank(regionName)) {
            expression = expression.and(QSubRegion.subRegion.region.name.contains(regionName));
        }

        return expression;
    }

}
