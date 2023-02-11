package com.matixtechies.customerservice.controller;

import com.matixtechies.customerservice.model.Customer;
import com.matixtechies.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable("id") int customerId){
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }
}
