package com.solarmaster.star.repository;

import org.springframework.stereotype.Repository;

import com.solarmaster.star.model.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    
}
