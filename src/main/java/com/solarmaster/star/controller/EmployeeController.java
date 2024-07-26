package com.solarmaster.star.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solarmaster.star.dto.EmployeeDTO;
import com.solarmaster.star.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/add")
    public EmployeeDTO postMethodName(@RequestBody EmployeeDTO entity) {
        return employeeService.createNewEmployee(entity);
    }

    @GetMapping(path = "/all")
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getAllEmployess();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping(path = "/")
    public EmployeeDTO getEmployeeQuery(@RequestParam("name") String name) {
        return new EmployeeDTO(12L, name, LocalDate.of(2007, 12, 3), true);
    }

}