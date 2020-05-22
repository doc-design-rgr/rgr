package com.rgr.project.webapp.repository;

import com.rgr.project.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<CardEntity, Long> {
}
