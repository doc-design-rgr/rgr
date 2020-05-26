package com.rgr.project.webapp.controller;

;
import com.rgr.project.entity.BouquetEntity;
import com.rgr.project.webapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    AppService service;

    @GetMapping
    public String getAllCustomBouquet (Map<String, Object> model){
        Iterable<BouquetEntity> bouquetEntities = service.getAllCustomBouquet();

        System.out.println(bouquetEntities);
        model.put("customBouquet",bouquetEntities);
        return "catalog";
    }

    @GetMapping("getEvent")
    public String getAllCustomBouquetEvent (Map<String, Object> model){
        Iterable<BouquetEntity> event = service.getEvent();

        System.out.println(event);
        model.put("event",event);
        return "catalog";
    }
}
