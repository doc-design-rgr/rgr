package com.rgr.project.webapp.repository;

import com.rgr.project.entity.BouquetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BouquetRepo extends JpaRepository<BouquetEntity, Long> {

    //List<BouquetEntity> getBouquetEntitiesByBouquetEventEquals(String bouquetEvent);


    @Query("select bq from BouquetEntity bq where bq.bouquetEvent = ?1")
    List<BouquetEntity> getBouquetBasedEvent(String bouquetEvent);


    @Query(
            value = "select *\n" +
                    "from rgr_flower_system.bouquet limit 4;",
            nativeQuery = true)
    List<BouquetEntity> getAllEvent();
}
