package com.rgr.project.webapp.service;

import com.rgr.project.entity.CustomerEntity;
import com.rgr.project.webapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    CustomerRepo customerRepo;

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepo.save(customerEntity);
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }

    public CustomerEntity getCustomerById(Integer customerId) {
        return customerRepo.findCustomerByCustomerId(customerId);
    }

    public CustomerEntity getLoggedCustomer(String customerEmail, String customerPassword) {
        return customerRepo.findCustomerByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
    }
}