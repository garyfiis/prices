package com.store.prices.infra.repository.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="PRICES_RULES")
@Data
public class PriceRules implements Serializable {

    @EmbeddedId
    private PriceRulesKey key;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "CURR")
    private String currency;

}
