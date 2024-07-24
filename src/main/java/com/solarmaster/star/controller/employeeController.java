package com.solarmaster.star.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class employeeController {

    @GetMapping(path = "/employees")
    public String getEmployees() {
        return "Hello world";
    }

}
