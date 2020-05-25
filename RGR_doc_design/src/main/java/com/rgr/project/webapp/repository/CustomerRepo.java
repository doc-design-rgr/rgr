package com.rgr.project.webapp.repository;

import com.rgr.project.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

    CustomerEntity findCustomerByCustomerId(Integer id);

    CustomerEntity findCustomerByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);

}
