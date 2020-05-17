package com.fx.rentcloud.profileservice.service;

import com.fx.rentcloud.commons.model.Customer;
import com.fx.rentcloud.profileservice.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }
}
