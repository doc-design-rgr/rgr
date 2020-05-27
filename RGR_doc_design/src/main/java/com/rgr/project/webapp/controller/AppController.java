package com.rgr.project.webapp.controller;

;
import com.rgr.project.entity.BouquetEntity;
import com.rgr.project.entity.DeliveryEntity;
import com.rgr.project.entity.FlowersEntity;
import com.rgr.project.entity.PackingEntity;
import com.rgr.project.webapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    AppService service;

/*    @GetMapping
    public String mainScreen(Map<String, Object> model){
        Iterable<FlowersEntity> flower = service.getFlower();
        Iterable<PackingEntity> packing = service.getPacking();
        Iterable<DeliveryEntity> delivery = service.getDelivery();
        model.put("flower",flower);
        model.put("packing", packing);
        model.put("delivery", delivery);
        return "custom";
    }*/

    @GetMapping("showFlowers")
    public String flowerForBouquet (Map<String, Object> model){
        Iterable<FlowersEntity> flower = service.getFlower();
        System.out.println(flower);
        model.put("flower",flower);
//        model.put("flowerForBouquet", flower.toString());
        return "custom";
    }

    @GetMapping("addToOrder")
    public String addFlowerToOrder(@RequestParam int number,Map<String, Object> model){
        Iterable<FlowersEntity> flower = service.getFlower();
        Iterable<PackingEntity> packing = service.getPacking();
        Iterable<DeliveryEntity> delivery = service.getDelivery();
        model.put("flower",flower);
        model.put("packing", packing);
        model.put("delivery", delivery);
        Map<String, Object> result = service.addFlowerToOrder(service.getAllFlowersById(number));
        model.put("currentOrder", result);
        model.put("order", result.get("flower"));
        model.put("price", result.get("price"));
        return "custom";
    }

    @PostMapping("acceptOrder")
    public String acceptOrder(@RequestParam int number,@RequestParam int delivery,
                              @RequestParam String phone) {
        service.makeOrder(number, delivery, phone);
        return "custom";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping
    public String getAllCustomBouquet (Map<String, Object> model){

        Iterable<BouquetEntity> bouquetEntities = service.getAllBouquetEntity();
        model.put("customBouquet",bouquetEntities);
        //Default parameter dropdown bar
        service.getParameterDropDownBar(model);

        return "catalog";
    }

    @GetMapping("getBouquetBasedEvent")
    public String getAllCustomBouquetBasedToEvent (@RequestParam String event, Map<String, Object> model){

        List<BouquetEntity> bouquetEntitiesBasedToEvent = service.getBouquetByEvent(event);
        model.put("customBouquetBasedFilter",bouquetEntitiesBasedToEvent);
        //Default parameter dropdown bar
        service.getParameterDropDownBar(model);

        return "catalog";
    }

    @PostMapping("addOrderBouquet")
    public String addOrderBouquet(@RequestParam int bouquet,@RequestParam int delivery,
                                  @RequestParam int packing, @RequestParam String phone, Map<String, Object> model) {
        //Post Order
        service.makeOrderBouquet(bouquet, delivery, packing, phone);

        Iterable<BouquetEntity> bouquetEntities = service.getAllBouquetEntity();
        model.put("customBouquet",bouquetEntities);
        //Default parameter dropdown bar
        service.getParameterDropDownBar(model);
        return "catalog";
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
