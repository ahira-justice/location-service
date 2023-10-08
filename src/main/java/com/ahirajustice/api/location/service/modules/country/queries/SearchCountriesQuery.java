package com.ahirajustice.api.location.service.modules.country.queries;

import com.ahirajustice.api.location.service.common.entities.BaseEntity;
import com.ahirajustice.api.location.service.common.entities.Country;
import com.ahirajustice.api.location.service.common.entities.QCountry;
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
public class SearchCountriesQuery extends BaseQuery {

    private String code;
    private String name;

    @Override
    protected Class<? extends BaseEntity> getSortEntityClass() {
        return Country.class;
    }

    @Override
    protected Predicate getPredicate(BooleanExpression expression) {
        if (StringUtils.isNotBlank(code)) {
            expression = expression.and(QCountry.country.code.contains(code));
        }

        if (StringUtils.isNotBlank(name)) {
            expression = expression.and(QCountry.country.name.contains(name));
        }

        return expression;
    }

}
