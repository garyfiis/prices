package com.store.prices.business;


import com.store.prices.business.dto.PriceRulesDto;
import com.store.prices.exception.RecordNotFoundException;

public interface RulesPriceService {

    PriceRulesDto getRulesPricePerDate(Integer brandId, String productId, String applicationDate) throws RecordNotFoundException;
}
