package com.rgr.project.webapp.repository;

import com.rgr.project.entity.DeliveryEntity;
import com.rgr.project.entity.PackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliverRepo extends JpaRepository<DeliveryEntity, Long> {
    @Query(value = "SELECT *, delivery_type FROM delivery d;",
            nativeQuery = true)
    List<DeliveryEntity> getAllDelivery();

    @Query("Select d from DeliveryEntity d where d.deliveryId = ?1")
    DeliveryEntity getDeliveryById(int id);
}
