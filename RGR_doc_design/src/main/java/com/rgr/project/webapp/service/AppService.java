package com.rgr.project.webapp.service;

import com.rgr.project.entity.BouquetEntity;
import com.rgr.project.webapp.repository.BouquetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private BouquetRepo bouquetRepo;

    public Iterable<BouquetEntity> getAllCustomBouquet(){
        return bouquetRepo.findAll();
    }

    public List<BouquetEntity> getEvent(){
        return bouquetRepo.getAllEvent();
    }

    public List<BouquetEntity> getBouquetBasedEvent(String bouquetEvent){
        return bouquetRepo.getBouquetBasedEvent(bouquetEvent);
    }
}
