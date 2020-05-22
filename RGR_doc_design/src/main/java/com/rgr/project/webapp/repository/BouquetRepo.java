package com.rgr.project.webapp.repository;

import com.rgr.project.entity.BouquetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BouquetRepo extends JpaRepository<BouquetEntity, Long> {
}
