package com.example.eglbmobfkzgieoqusdjl.customer.controller;

import com.example.eglbmobfkzgieoqusdjl.customer.model.Customer;
import com.example.eglbmobfkzgieoqusdjl.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
    }
}
