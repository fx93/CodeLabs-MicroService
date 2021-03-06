package com.fx.rentcloud.profileservice.controller;

import com.fx.rentcloud.commons.model.Customer;
import com.fx.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public Customer fetch(@PathVariable(value = "id") int profileId) {
        return customerService.fetchById(profileId);
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('read_profile')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }
}
