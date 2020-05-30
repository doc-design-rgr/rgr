package com.rgr.project.webapp.repository;

import com.rgr.project.entity.BouquetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BouquetRepo extends JpaRepository<BouquetEntity, Long> {
    @Repository
    public class CatalogBouquetRepository implements BouquetRepo {

        private Set<Bouquet> bouques = new HashSet<>();

        @Override
        public String getName() {
            return "From Catalog";
        }

        @Override
        public void addBouquet(Bouquet bouquet) {
            Order.add(bouquet);
        }

        @Override
        public Collection<Bouquet> allBouquet() {
            return new HashSet<>(bouquets);
        }

    }
}
