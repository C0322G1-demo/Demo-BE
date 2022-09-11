package com.example.controller;

import com.example.module.Employee;
import com.example.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    /**
     * Created by: SangNH
     * Date created: 08/09/2022
     * Function: Show list Employee
     * @return HTTP status code 204 (NO_CONTENT)
     * HTTP status code 200 (OK): return employees
     */
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findByAll();

        if (employees == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
