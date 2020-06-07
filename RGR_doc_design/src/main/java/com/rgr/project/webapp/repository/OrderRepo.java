package com.rgr.project.webapp.repository;

import com.rgr.project.entity.OrderInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderInfoEntity, Long> {
    @Query("select oi from OrderInfoEntity oi where oi.customerId=?1")
    List<OrderInfoEntity> getOrdersByCustomerId(int id);
}
