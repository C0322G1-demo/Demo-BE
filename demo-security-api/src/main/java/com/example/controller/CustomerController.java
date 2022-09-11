package com.example.controller;

import com.example.module.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/public/")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getListCustomer() {
        List<Customer> customerList = customerService.findByAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
