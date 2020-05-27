package com.rgr.project.logic;

import java.util.ArrayList;
import java.util.List;

public class CustomBouquet implements BouquetBuilder {
    private List<String> flowers = new ArrayList<String>();
    private double price = 0;

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getFlowers() {
        return flowers;
    }

    @Override
    public void addFlowers(String flower) {
        flowers.add(flower);
        System.out.println(flowers);
    }

    @Override
    public double sumPrice(double p) {
        price = price + p;
        return price;
    }

    @Override
    public double calculatePriceWithDiscount(String d) {
        double discount = Double.parseDouble(d);
        double totalDiscount = 100 - discount;
        price = (totalDiscount*price)/100;
        return price;
    }

    @Override
    public double Packing(String pricePacking) {
        double pp = Double.parseDouble(pricePacking);
        price = price + pp;
        return price;
    }
}
