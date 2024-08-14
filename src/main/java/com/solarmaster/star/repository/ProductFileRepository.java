package com.solarmaster.star.repository;

import com.solarmaster.star.model.ProductFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFileRepository extends JpaRepository<ProductFile, Integer> {
}
