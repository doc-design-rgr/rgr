package com.rgr.project.webapp.repository;

import com.rgr.project.entity.BouquetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BouquetRepo extends JpaRepository<BouquetEntity, Long> {

    @Query(
            value = "SELECT distinct *, a.bouquet_event FROM rgr_flower_system.bouquet a;",
            nativeQuery = true)
    List<BouquetEntity> getAllEvent();
}
