package com.solarmaster.star.repository;

import com.solarmaster.star.model.ProductAttributeOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeOptionRepository extends JpaRepository<ProductAttributeOption, Integer> {
}
