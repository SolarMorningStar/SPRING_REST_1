package com.solarmaster.star.repository;

import com.solarmaster.star.model.ProductVariantCombination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantCombinationRepository extends JpaRepository<ProductVariantCombination, Integer> {
}
