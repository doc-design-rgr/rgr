package com.rgr.project.webapp.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BouquetRepo  {

    private Set<Bouquet> heroes = new HashSet<>();

    @PostConstruct
    public void init() {
        bouquets.add(new Bouquet("123", "321", BouquetEntity.bouquet_id));
        bouquets.add(new Bouquet("rose", "123", FloweEntity.flower_id));
    }

    public void addBouquet(Bouquet Bouquet) {
        heroes.add(Bouquet);
    }

    public Collection<Bouquet> allBouquets() {
        return new HashSet<>(bouquets);
    }



}
