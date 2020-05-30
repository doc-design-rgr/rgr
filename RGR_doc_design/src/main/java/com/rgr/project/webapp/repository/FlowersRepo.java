package com.rgr.project.webapp.repository;

import com.rgr.project.entity.FlowersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface FlowersRepo extends JpaRepository<FlowersEntity, Long> {

    @Repository
    public class FlowersRepo implements BouquetRepo {

        private List<Flower> flowers = new ArrayList<>();

        @Override
        public void addBouquet(Flower flower) {
            Flowers.add(flower);
        }

        @Override
        public Collection<Flower> allflowers() {
            return List.copyOf(flowers);
        }

        @Override
        public String getName() {
            return "Custom Bouquet";
        }
}
