package com.example.service.impl;

import com.example.module.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * Create by SangNH
     * Date: 08/09/2022
     * find out all list
     * @return employeeRepository.findAll()
     */
    @Override
    public List<Employee> findByAll() {
        return employeeRepository.findAll();
    }
}
