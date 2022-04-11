package com.store.prices.infra.repository;

import com.store.prices.infra.repository.domain.PriceRules;
import com.store.prices.infra.repository.domain.PriceRulesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRulesRepository extends JpaRepository<PriceRules, PriceRulesKey> {


    Optional<PriceRules> findFirstByKeyBrandIdAndKeyProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Integer brandId, String productId, String startDate, String endDate);

}
