package com.ahirajustice.api.location.service.modules.region.queries;

import com.ahirajustice.api.location.service.common.entities.BaseEntity;
import com.ahirajustice.api.location.service.common.entities.QRegion;
import com.ahirajustice.api.location.service.common.entities.Region;
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
public class SearchRegionsQuery extends BaseQuery {

    private String code;
    private String name;
    private String countryCode;
    private String countryName;

    @Override
    protected Class<? extends BaseEntity> getSortEntityClass() {
        return Region.class;
    }

    @Override
    protected Predicate getPredicate(BooleanExpression expression) {
        if (StringUtils.isNotBlank(code)) {
            expression = expression.and(QRegion.region.code.contains(code));
        }

        if (StringUtils.isNotBlank(name)) {
            expression = expression.and(QRegion.region.name.contains(name));
        }

        if (StringUtils.isNotBlank(countryCode)) {
            expression = expression.and(QRegion.region.country.code.contains(countryCode));
        }

        if (StringUtils.isNotBlank(countryName)) {
            expression = expression.and(QRegion.region.country.name.contains(countryName));
        }

        return expression;
    }

}
