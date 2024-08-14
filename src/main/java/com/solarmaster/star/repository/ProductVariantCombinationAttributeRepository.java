package com.solarmaster.star.repository;

import com.solarmaster.star.model.ProductVariantCombinationAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantCombinationAttributeRepository extends JpaRepository<ProductVariantCombinationAttribute, Integer> {
}
