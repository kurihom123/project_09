package com.matixtechies.customerservice.service;

import com.matixtechies.customerservice.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Optional<Customer> getCustomerById(int customerId);
}
