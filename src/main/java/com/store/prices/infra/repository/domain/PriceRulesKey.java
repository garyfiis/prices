package com.store.prices.infra.repository.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PriceRulesKey implements Serializable {

    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRICE_LIST")
    private String priceList;

}
