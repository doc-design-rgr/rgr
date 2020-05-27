package com.rgr.project.webapp.repository;

import com.rgr.project.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepo extends JpaRepository<CardEntity, Long> {
    @Query("select cd from CardEntity cd where cd.cardId =?1")
    CardEntity getAllById(int id);
}
