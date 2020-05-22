package com.rgr.project.webapp.controller;

;
import com.rgr.project.webapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    AppService service;

    @GetMapping
    public String mainScreen(){
        return "login";
    }
}
