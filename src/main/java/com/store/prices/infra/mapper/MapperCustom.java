package com.store.prices.infra.mapper;

import com.store.prices.business.dto.PriceRulesDto;
import com.store.prices.infra.repository.domain.PriceRules;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MapperCustom {

    @Mappings({
            @Mapping(source = "key.brandId", target = "brandId"),
            @Mapping(source = "key.productId", target = "productId"),
            @Mapping(source = "key.priceList", target = "priceList")
    })
    PriceRulesDto toPriceRulesDto(PriceRules priceRules);
}
