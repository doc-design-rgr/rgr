package com.rgr.project.webapp.controller;

import com.rgr.project.entity.CustomerEntity;
import com.rgr.project.webapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AppController {
    @Autowired
    AppService service;

    @GetMapping
    public String getCustomers(Map<String, Object> model) {
        return "login";
    }

    @PostMapping("/register/profile")
    public String add(@RequestParam String customerName, @RequestParam String customerPhone,
                      @RequestParam String customerEmail, @RequestParam String customerPassword,
                      Map<String, Object> model) {
        CustomerEntity customerEntity = new CustomerEntity(customerName, customerPhone,
                customerEmail, customerPassword);
        service.createCustomer(customerEntity);
        model.put("greeting", "Welcome");
        model.put("loggedName", customerEntity.getCustomerName());
        return "profile";
    }

    @PostMapping("/profile")
    public String login(@RequestParam String customerEmail, @RequestParam String customerPassword,
                        Map<String, Object> model) {
        CustomerEntity customerEntity = service.getLoggedCustomer(customerEmail, customerPassword);
        model.put("greeting", "Welcome back");
        model.put("loggedName", customerEntity.getCustomerName());
        return "profile";
    }
}
