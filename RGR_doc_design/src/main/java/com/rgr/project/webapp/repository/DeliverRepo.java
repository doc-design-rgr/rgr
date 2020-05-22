package com.rgr.project.webapp.repository;

import com.rgr.project.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverRepo extends JpaRepository<DeliveryEntity, Long> {
}
