package com.rgr.project.logic;

public class Bouquet implements  BouquetBuilder{

    private String name;
    private double price;

    public Bouquet(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void addFlowers(String flower) {

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
    public double Packing(String packing) {
        double pp = Double.parseDouble(packing);
        price = price + pp;
        return price;
    }
}
