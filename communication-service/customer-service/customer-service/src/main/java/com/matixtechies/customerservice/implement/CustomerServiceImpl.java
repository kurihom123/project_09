package com.matixtechies.customerservice.implement;

import com.matixtechies.customerservice.model.Customer;
import com.matixtechies.customerservice.repository.CustomerRepository;
import com.matixtechies.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Optional<Customer> getCustomerById(int customerId){
        return customerRepository.findById(customerId);
    }
}
