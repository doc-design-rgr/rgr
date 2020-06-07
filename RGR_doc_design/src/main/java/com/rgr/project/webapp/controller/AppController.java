package com.rgr.project.webapp.controller;

;
import com.rgr.project.entity.*;
import com.rgr.project.logic.Bouquet;
import com.rgr.project.webapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.AttributeList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        customerEntity.setCustomerCard(0);
        service.createCustomer(customerEntity);
        if (customerEntity.getCustomerCard() >= 1) {
            model.put("cardBlock", service.getCardById(customerEntity.getCustomerCard()));
        }
        model.put("profileBlock", customerEntity);
        return "profile";
    }

    @PostMapping("/profile")
    public String login(@RequestParam String customerEmail, @RequestParam String customerPassword,
                        Map<String, Object> model) throws ParseException {
        CustomerEntity customerEntity = service.getLoggedCustomer(customerEmail, customerPassword);
        List<OrderInfoEntity> orders = service.getOrderByCustomerId(customerEntity.getCustomerId());
        List data = createMap(orders);
        model.put("orders", data);
        Map<String, Object> message = checkDate(orders);
        if (message.get("orderId") != "none") {
            System.out.println("here");
            model.put("message", message);
        }
        model.put("profileBlock", customerEntity);
        return "profile";
    }

    public Object transformCatalogBouquets(Map<String, Object> map, OrderInfoEntity orderInfoEntity) {
        BouquetEntity bouquet;
        if (orderInfoEntity.getBouquetId() != null) {
            bouquet = service.getBouquetFromOrders(orderInfoEntity.getBouquetId());
            return map.put("bouquetName", bouquet.getBouquetName());
        }
        return map.put("bouquetName", "none");
    }

    public Object transformCustomBouquets(Map<String, Object> map, OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity.getCustomBouquet() != null) {
            return map.put("customBouquet", "true");
        }
        return map.put("customBouquet", "none");
    }

    public Map<String, Object> checkDate(List<OrderInfoEntity> orders) {
        Date date = new Date();
        Map<String, Object> map = new HashMap<>();
        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        for (int i = 0; i < orders.size(); i++) {
            orderInfoEntity = orders.get(i);
            long diff = date.getTime() - orderInfoEntity.getOrderDate().getTime();
            long diffDays = diff / (60 * 60 * 1000 * 24);
            long diffMinutes = diff / (60 * 1000) % 60;
            System.out.println("minutes" + diffMinutes);
            System.out.println("days" + diffDays);

            if (diffDays < 1 && diffMinutes < 5) {
                map.put("orderId", orderInfoEntity.getOrderId());
                return map;
            }
        }
        map.put("orderId", "none");
        return map;
    }

    public List<Object> createMap(List<OrderInfoEntity> orders) {
        List data = new ArrayList();
        for (int i = 0; i < orders.size(); i++) {
            OrderInfoEntity orderInfoEntity;
            orderInfoEntity = orders.get(i);
            DeliveryEntity delivery = service.getDeliveryById(orderInfoEntity.getDeliveryId());
            PackingEntity packing = service.getPackingById(orderInfoEntity.getPackingId());
            Map<String, Object> map = new HashMap<>();
            map.put("orderId", orderInfoEntity.getOrderId());
            map.put("cost", orderInfoEntity.getCost());
            map.put("deliveryType", delivery.getDeliveryType());
            map.put("packingType", packing.getPackingType());
            map.put("orderDate", orderInfoEntity.getOrderDate());
            transformCatalogBouquets(map, orderInfoEntity);
            transformCustomBouquets(map, orderInfoEntity);

            data.add(map);
        }
        return data;
    }

    @GetMapping("createCustom")
    public String mainScreen(Map<String, Object> model) {
        Iterable<FlowersEntity> flower = service.getFlower();
        Iterable<PackingEntity> packing = service.getPacking();
        Iterable<DeliveryEntity> delivery = service.getDelivery();
        model.put("flower", flower);
        model.put("packing", packing);
        model.put("delivery", delivery);

        return "custom";
    }

    @GetMapping("showFlowers")
    public String flowerForBouquet(Map<String, Object> model) {
        Iterable<FlowersEntity> flower = service.getFlower();
        System.out.println(flower);
        model.put("flower", flower);
        return "custom";
    }

    @GetMapping("addToOrder")
    public String addFlowerToOrder(@RequestParam int number, Map<String, Object> model) {
        Iterable<FlowersEntity> flower = service.getFlower();
        Iterable<PackingEntity> packing = service.getPacking();
        Iterable<DeliveryEntity> delivery = service.getDelivery();
        model.put("flower", flower);
        model.put("packing", packing);
        model.put("delivery", delivery);
        Map<String, Object> result = service.addFlowerToOrder(service.getAllFlowersById(number));
        model.put("currentOrder", result);
        model.put("order", result.get("flower"));
        model.put("price", result.get("price"));
        return "custom";
    }

    @PostMapping("acceptOrder")
    public String acceptOrder(@RequestParam int number, @RequestParam int delivery,
                              @RequestParam String phone) {
        service.makeOrder(number, delivery, phone);
        return "login";
    }

    @GetMapping("chooseCatalog")
    public String getAllCustomBouquet(Map<String, Object> model) {

        Iterable<BouquetEntity> bouquetEntities = service.getAllBouquetEntity();
        model.put("customBouquet", bouquetEntities);
        service.getParameterDropDownBar(model);

        return "catalog";
    }

    @GetMapping("getBouquetBasedEvent")
    public String getAllCustomBouquetBasedToEvent(@RequestParam String event, Map<String, Object> model) {

        List<BouquetEntity> bouquetEntitiesBasedToEvent = service.getBouquetByEvent(event);
        model.put("customBouquetBasedFilter", bouquetEntitiesBasedToEvent);
        service.getParameterDropDownBar(model);

        return "catalog";
    }

    @PostMapping("addOrderBouquet")
    public String addOrderBouquet(@RequestParam int bouquet, @RequestParam int delivery,
                                  @RequestParam int packing, @RequestParam String phone, Map<String, Object> model) {
        service.makeOrderBouquet(bouquet, delivery, packing, phone);
        Iterable<BouquetEntity> bouquetEntities = service.getAllBouquetEntity();
        model.put("customBouquet", bouquetEntities);
        service.getParameterDropDownBar(model);
        return "login";
    }
}
