package com.store.prices.resources;

import com.store.prices.business.RulesPriceService;
import com.store.prices.business.dto.PriceRulesDto;
import com.store.prices.exception.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PriceRulesController {

    public static final String ROOT_RULES_PRICES = "/rules/prices/brands/{brandId}/products/{productId}";

    @Autowired
    private RulesPriceService rulesPricesService;

    @GetMapping(path = ROOT_RULES_PRICES)
    public PriceRulesDto getRulesPrices(
            @PathVariable("brandId") Integer brandId,
            @PathVariable("productId") String productId,
            @RequestParam String applicationDate) throws RecordNotFoundException {
        log.info("Requesting for brand {}, product {} and date {}", brandId, productId, applicationDate);

        return rulesPricesService.getRulesPricePerDate(brandId, productId, applicationDate);

    }

}
