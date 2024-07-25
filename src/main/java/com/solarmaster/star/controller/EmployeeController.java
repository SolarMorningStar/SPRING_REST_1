package com.solarmaster.star.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solarmaster.star.dto.EmployeeDTO;
import com.solarmaster.star.service.EmployeeService;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees")
    public EmployeeDTO getEmployees() {
        return new EmployeeDTO(12l, "anug", LocalDate.of(2007, 12, 3), true);
    }

    @GetMapping(path = "/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping(path = "/employeename")
    public EmployeeDTO getEmployeeQuery(@RequestParam("name") String name) {
        return new EmployeeDTO(12L, name, LocalDate.of(2007, 12, 3), true);
    }
}