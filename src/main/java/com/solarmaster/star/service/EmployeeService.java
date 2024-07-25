package com.solarmaster.star.service;

import org.springframework.stereotype.Service;
import com.solarmaster.star.dto.EmployeeDTO;
import com.solarmaster.star.model.EmployeeEntity;
import com.solarmaster.star.repository.EmployeeRepository;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getReferenceById(id);
        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getJoiningDate(),
                employeeEntity.getIsActive());
    }
}
