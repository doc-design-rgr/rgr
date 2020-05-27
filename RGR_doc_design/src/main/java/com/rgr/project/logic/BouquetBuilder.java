package com.rgr.project.logic;

public interface BouquetBuilder {
    void addFlowers(String flower);
    double sumPrice(double p);
    double calculatePriceWithDiscount(String d);
    double Packing(String packing);
}
