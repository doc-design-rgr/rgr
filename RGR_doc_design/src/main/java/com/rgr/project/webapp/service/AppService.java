package com.rgr.project.webapp.service;

import com.rgr.project.entity.*;
import com.rgr.project.logic.Bouquet;
import com.rgr.project.logic.BouquetBuilder;
import com.rgr.project.logic.CustomBouquet;
import com.rgr.project.logic.Waiter;
import com.rgr.project.webapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService {

    CustomBouquet customBouquet = new CustomBouquet();
    Waiter waiter;
    Bouquet bouquetObject;

    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private PackingRepo packingRepo;
    @Autowired
    private FlowersRepo flowersRepo;
    @Autowired
    private DeliverRepo deliverRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private BouquetRepo bouquetRepo;

    public void getParameterDropDownBar(Map<String, Object> model) {

        Iterable<BouquetEntity> events = getListEvents();
        Iterable<PackingEntity> packing = getPacking();
        Iterable<DeliveryEntity> delivery = getDelivery();
        model.put("event", events);
        model.put("packing", packing);
        model.put("delivery", delivery);
    }

    public void makeOrderBouquet(int bouquet, int delivery, int packing, String phone) {
        Date date = new Date();
        BouquetEntity bouquetEntities = bouquetRepo.getBouquetById(bouquet);
        bouquetObject = new Bouquet(bouquetEntities.getBouquetName(), bouquetEntities.getPrice());
        Waiter waiter = new Waiter(bouquetObject);
        CustomerEntity customer = customerRepo.getCustomerById(phone);
        CardEntity card = cardRepo.getAllById(customer.getCustomerCard());
        PackingEntity packingObject = packingRepo.getPackingById(packing);
        Double priceBouquet = bouquetEntities.getPrice();
        customBouquet.setPrice(priceBouquet);
        customBouquet.Packing(packingObject.getPackingPrice().toString());
        OrderInfoEntity orders = new OrderInfoEntity();
        orders.setCustomerId(customer.getCustomerId());
        orders.setBouquetId(bouquetEntities.getBouquetId());
        orders.setDeliveryId(delivery);
        orders.setPackingId(packing);
        orders.setOrderDate(date);
        if (card.getCardDiscount() != null) {
            orders.setCost(waiter.calculateDiscount(card.getCardDiscount()));
        } else {
            orders.setCost(customBouquet.getPrice());
        }
        orderRepo.save(orders);
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

    public void makeOrder(int id, int deliveryId, String phone) {
        Waiter waiter = new Waiter(customBouquet);
        Map<String, Object> result = getAll(id, deliveryId, phone);
        OrderInfoEntity orders = new OrderInfoEntity();
        Date date = new Date();
        CardEntity card = (CardEntity) result.get("card");
        PackingEntity packing = (PackingEntity) result.get("packing");
        CustomerEntity customer = (CustomerEntity) result.get("customer");
        DeliveryEntity deliveryEntity = (DeliveryEntity) result.get("delivery");
        customBouquet.sumPrice(deliveryEntity.getDeliveryPrice());
        customBouquet.sumPrice(packing.getPackingPrice());
        orders.setCustomerId(customer.getCustomerId());
        orders.setCustomBouquet(1);
        orders.setDeliveryId(deliveryId);
        orders.setOrderDate(date);
        orders.setPackingId(packing.getPackingId());
        if (card.getCardDiscount() != null) {
            orders.setCost(waiter.calculateDiscount(card.getCardDiscount()));
            System.out.println(waiter.calculateDiscount(card.getCardDiscount()));
            customBouquet.getFlowers().clear();
            customBouquet.setPrice(0);
        } else {
            orders.setCost(customBouquet.getPrice());
        }
        orderRepo.save(orders);
    }

    public Map<String, Object> addFlowerToOrder(FlowersEntity flowersEntity) {
        waiter = new Waiter(customBouquet);
        String name = flowersEntity.getFlowerName();
        double price = flowersEntity.getFlowerPrice();
        waiter.constructBouquet(name, price);
        Map<String, Object> map = new HashMap<>();
        map.put("flower", customBouquet.getFlowers());
        map.put("price", customBouquet.getPrice());
        return map;
    }

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepo.save(customerEntity);
    }

    public CustomerEntity getLoggedCustomer(String customerEmail, String customerPassword) {
        return customerRepo.findCustomerByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
    }

    public CardEntity getCardById(int id) {
        return cardRepo.getById(id);
    }

    public List<OrderInfoEntity> getOrderByCustomerId(int id) {
        return orderRepo.getOrdersByCustomerId(id);
    }

    public Iterable<BouquetEntity> getAllBouquetEntity() {
        return bouquetRepo.findAll();
    }

    public List<BouquetEntity> getListEvents() {
        return bouquetRepo.getAllEvents();
    }

    public List<BouquetEntity> getBouquetByEvent(String bouquetEvent) {
        return bouquetRepo.getBouquetByEvent(bouquetEvent);
    }

    public BouquetEntity getBouquetFromOrders(int id) {
        return bouquetRepo.getBouquetById(id);
    }

    public DeliveryEntity getDeliveryById(int id) {
        return deliverRepo.getDeliveryById(id);
    }

    public PackingEntity getPackingById(int id) {
        return packingRepo.getPackingById(id);
    }

    public List<FlowersEntity> getFlower() {
        return flowersRepo.getAllFlowers();
    }

    public FlowersEntity getAllFlowersById(int id) {
        return flowersRepo.getAllFlowersById(id);
    }

    public List<PackingEntity> getPacking() {
        return packingRepo.getAllTypeOfPacking();
    }

    public List<DeliveryEntity> getDelivery() {
        return deliverRepo.getAllDelivery();
    }


}
