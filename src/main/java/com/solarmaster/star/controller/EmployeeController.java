package com.solarmaster.star.controller;

import com.solarmaster.star.dto.EmployeeDTO;
import com.solarmaster.star.service.EmployeeService;
import com.solarmaster.star.util.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/add")
    public EmployeeDTO postMethodName(@RequestBody EmployeeDTO entity) {
        return employeeService.createNewEmployee(entity);
    }

    @GetMapping(path = "/all")
    public List<EmployeeDTO> getEmployees(
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_NUMBER) Integer pageNumber,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_PAGE_LIMIT) Integer pageLimit,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "" + Constants.DEFAULT_SORT_ORDER) Boolean sortOrder) {
        try {
            return employeeService.getAllEmployees(pageNumber, pageLimit, sortBy, sortOrder);
        } catch (Exception e) {
            logger.error("Error fetching employees with pageNumber: {}, pageLimit: {}, sortBy: {}, sortOrder: {}",
                    pageNumber, pageLimit, sortBy, sortOrder, e);
            throw e;
        }
    }


    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping(path = "/details")
    public EmployeeDTO getEmployeeQuery(@RequestParam("id") Long id) {
        return employeeService.getEmployeeById(id);
    }
}