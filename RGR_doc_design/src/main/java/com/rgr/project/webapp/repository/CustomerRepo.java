package com.rgr.project.webapp.repository;

import com.rgr.project.entity.CustomerEntity;
import com.rgr.project.entity.PackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
    @Query("select cs from CustomerEntity cs where cs.customerPhone =?1")
    CustomerEntity getCustomerById(String phone);

    CustomerEntity findCustomerByCustomerId(Integer id);

    CustomerEntity findCustomerByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);
}
