package com.store.prices.infra.mapper;

import com.store.prices.business.dto.PriceRulesDto;
import com.store.prices.infra.repository.domain.PriceRules;
import com.store.prices.infra.repository.domain.PriceRulesKey;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-11T10:32:34+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class MapperCustomImpl implements MapperCustom {

    @Override
    public PriceRulesDto toPriceRulesDto(PriceRules priceRules) {
        if ( priceRules == null ) {
            return null;
        }

        PriceRulesDto priceRulesDto = new PriceRulesDto();

        priceRulesDto.setBrandId( priceRulesKeyBrandId( priceRules ) );
        priceRulesDto.setProductId( priceRulesKeyProductId( priceRules ) );
        priceRulesDto.setPriceList( priceRulesKeyPriceList( priceRules ) );
        priceRulesDto.setStartDate( priceRules.getStartDate() );
        priceRulesDto.setEndDate( priceRules.getEndDate() );
        priceRulesDto.setPriority( priceRules.getPriority() );
        priceRulesDto.setPrice( priceRules.getPrice() );
        priceRulesDto.setCurrency( priceRules.getCurrency() );

        return priceRulesDto;
    }

    private Integer priceRulesKeyBrandId(PriceRules priceRules) {
        if ( priceRules == null ) {
            return null;
        }
        PriceRulesKey key = priceRules.getKey();
        if ( key == null ) {
            return null;
        }
        Integer brandId = key.getBrandId();
        if ( brandId == null ) {
            return null;
        }
        return brandId;
    }

    private String priceRulesKeyProductId(PriceRules priceRules) {
        if ( priceRules == null ) {
            return null;
        }
        PriceRulesKey key = priceRules.getKey();
        if ( key == null ) {
            return null;
        }
        String productId = key.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private String priceRulesKeyPriceList(PriceRules priceRules) {
        if ( priceRules == null ) {
            return null;
        }
        PriceRulesKey key = priceRules.getKey();
        if ( key == null ) {
            return null;
        }
        String priceList = key.getPriceList();
        if ( priceList == null ) {
            return null;
        }
        return priceList;
    }
}
