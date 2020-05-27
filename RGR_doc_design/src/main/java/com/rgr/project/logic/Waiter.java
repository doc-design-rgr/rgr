package com.rgr.project.logic;

public class Waiter {
    CustomBouquet bouquet;

    public Waiter(CustomBouquet bouquet) {
        this.bouquet = bouquet;
    }

    public void constructBouquet(String flower, double price){
        bouquet.addFlowers(flower);
        System.out.println(bouquet.sumPrice(price));
    }


    public double calculateDiscount(String discount){
        double finalPrice = bouquet.calculatePriceWithDiscount(discount);
        System.out.println("Discount: " + discount);
        return finalPrice;
    }


}
