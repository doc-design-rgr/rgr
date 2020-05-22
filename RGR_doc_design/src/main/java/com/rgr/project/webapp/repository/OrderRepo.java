package com.rgr.project.webapp.repository;

import com.rgr.project.entity.OrderInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderInfoEntity, Long> {
}
