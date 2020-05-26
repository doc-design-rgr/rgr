package com.rgr.project.webapp.service;

import com.rgr.project.entity.*;
import com.rgr.project.logic.CustomBouquet;
import com.rgr.project.logic.Waiter;
import com.rgr.project.webapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService {
    CustomBouquet customBouquet = new CustomBouquet();
    Waiter waiter = new Waiter(customBouquet);

    @Autowired
    CardRepo cardRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    PackingRepo packingRepo;
    @Autowired
    FlowersRepo flowersRepo;
    @Autowired
    DeliverRepo deliverRepo;
    @Autowired
    OrderRepo orderRepo;


    public List<FlowersEntity> getFlower() {
        return flowersRepo.getAllFlowers();
    }

    public FlowersEntity getAllFlowersById(int id) {
        return flowersRepo.getAllFlowersById(id);
    }

    public Map<String, Object> getAll(int id, int deliveryId, String phone) {
        CustomerEntity customer = customerRepo.getCustomerById(phone);
        CardEntity card = cardRepo.getAllById(customer.getCustomerCard());
        DeliveryEntity delivery = deliverRepo.getDeliveryById(deliveryId);
        PackingEntity packing = packingRepo.getPackingById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("card", card);
        map.put("customer", customer);
        map.put("delivery", delivery);
        map.put("packing", packing);
        return map;
    }

    public List<PackingEntity> getPacking() {
        return packingRepo.getAllTypeOfPacking();
    }

    public List<DeliveryEntity> getDelivery() {
        return deliverRepo.getAllDelivery();
    }

    public void makeOrder(int id, int deliveryId, String phone) {
        Map<String, Object> result = getAll(id, deliveryId, phone);
        CardEntity card = (CardEntity) result.get("card");
        PackingEntity packing = (PackingEntity)  result.get("packing");
        OrderInfoEntity orders = new OrderInfoEntity();
        CustomerEntity customer = (CustomerEntity) result.get("customer");
        DeliveryEntity deliveryEntity = (DeliveryEntity) result.get("delivery");
        customBouquet.sumPrice(deliveryEntity.getDeliveryPrice());
        customBouquet.sumPrice(packing.getPackingPrice());
        orders.setCustomerId(customer.getCustomerId());
        orders.setCustomBouquet(1);
        orders.setDeliveryId(deliveryId);
        if (card.getCardDiscount() != null) {
            orders.setCost(waiter.calculateDiscount(card.getCardDiscount()));
            System.out.println(waiter.calculateDiscount(card.getCardDiscount()));
            customBouquet.getFlowers().clear();
            customBouquet.setPrice(0);
        }
        orderRepo.save(orders);
    }

    public Map<String, Object> addFlowerToOrder(FlowersEntity flowersEntity) {
        String name = flowersEntity.getFlowerName();
        double price = flowersEntity.getFlowerPrice();
        waiter.constructBouquet(name, price);
        Map<String, Object> map = new HashMap<>();
        map.put("flower", customBouquet.getFlowers());
        map.put("price", customBouquet.getPrice());
        return map;
    }

}
