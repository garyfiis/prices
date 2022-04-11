package com.store.prices.business.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceRulesDto {

    private Integer brandId;

    private String startDate;

    private String endDate;

    private String priceList;

    private String productId;

    private Integer priority;

    private double price;

    private String currency;
}
