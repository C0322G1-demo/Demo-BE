package com.example.service;

import com.example.module.Customer;
import com.example.module.Employee;

import java.util.List;

public interface ICustomerService {
    List<Customer> findByAll();
}
