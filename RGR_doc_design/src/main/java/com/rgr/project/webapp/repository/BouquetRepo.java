package com.rgr.project.webapp.repository;

import com.rgr.project.entity.BouquetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BouquetRepo extends JpaRepository<BouquetEntity, Long> {

    @Query("select bq from BouquetEntity bq where bq.bouquetId =?1")
    BouquetEntity getBouquetById(int id);

    @Query("select  bq from  BouquetEntity  bq where bq.bouquetId=?1")
    List<BouquetEntity> getBouquetEntitiesByOrdersId(int id);

    @Query("select bq from BouquetEntity bq where bq.bouquetEvent = ?1")
    List<BouquetEntity> getBouquetByEvent(String bouquetEvent);

    @Query(value = "select * from rgr_flower_system.bouquet limit 4;", nativeQuery = true)
    List<BouquetEntity> getAllEvents();
}
