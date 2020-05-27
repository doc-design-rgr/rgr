package com.rgr.project.webapp.repository;

import com.rgr.project.entity.FlowersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowersRepo extends JpaRepository<FlowersEntity, Long> {
    @Query(value = "SELECT *,a.flower_name FROM rgr_flower_system.flowers a;",
            nativeQuery = true)
    List<FlowersEntity> getAllFlowers();

    @Query("select f from FlowersEntity f where f.flowerId = ?1")
    FlowersEntity getAllFlowersById(int id);
}
