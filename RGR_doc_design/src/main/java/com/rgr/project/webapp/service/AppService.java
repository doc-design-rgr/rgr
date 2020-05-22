package com.rgr.project.webapp.service;

import com.rgr.project.webapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    @Autowired
    CustomerRepo customer;
//    Добавите подібне за потребою

}
