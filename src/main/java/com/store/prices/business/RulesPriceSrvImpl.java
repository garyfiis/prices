package com.store.prices.business;

import com.store.prices.business.dto.PriceRulesDto;
import com.store.prices.exception.RecordNotFoundException;
import com.store.prices.infra.mapper.MapperCustom;
import com.store.prices.infra.repository.PriceRulesRepository;
import com.store.prices.infra.repository.domain.PriceRules;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RulesPriceSrvImpl implements RulesPriceService {

    @Autowired
    PriceRulesRepository priceRulesRepository;

    @Autowired
    MapperCustom mapperEntityToDto;

    @Override
    public PriceRulesDto getRulesPricePerDate(Integer brandId, String productId, String applicationDate) throws RecordNotFoundException {

        log.info("Processing bussiness with brand {}, product {} and date {}", brandId, productId, applicationDate);

        PriceRules entity = priceRulesRepository
                .findFirstByKeyBrandIdAndKeyProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        brandId, productId, applicationDate, applicationDate).orElseThrow(() -> new RecordNotFoundException("There is no information for given parameters"));

        log.info("The result is {}", entity);
        return mapperEntityToDto.toPriceRulesDto(entity);

    }

}
