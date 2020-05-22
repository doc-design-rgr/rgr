package com.rgr.project.webapp.repository;

import com.rgr.project.entity.FlowersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowersRepo extends JpaRepository<FlowersEntity, Long> {
}
