package com.rgr.project.webapp.controller;

import com.rgr.project.entity.BouquetEntity;
import com.rgr.project.webapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    AppService service;

    @GetMapping
    public String getAllCustomBouquet (Map<String, Object> model){

        Iterable<BouquetEntity> bouquetEntities = service.getAllCustomBouquet();
        Iterable<BouquetEntity> events = service.getEvent();

        model.put("event",events);
        model.put("customBouquet",bouquetEntities);

        return "catalog";
    }

    @GetMapping("getEvent")
    public String getAllCustomBouquetEvent (@RequestParam String cars, Map<String, Object> model){

        List<BouquetEntity> bouquetEntitiesBasedEvent = service.getBouquetBasedEvent(cars);
        Iterable<BouquetEntity> events = service.getEvent();


        System.out.println(events);
        System.out.println(bouquetEntitiesBasedEvent);
        model.put("event",events);
        model.put("customBouquetBasedFilter",bouquetEntitiesBasedEvent);

        return "catalog";
    }
}
