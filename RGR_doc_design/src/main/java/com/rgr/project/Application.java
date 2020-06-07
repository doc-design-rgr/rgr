package com.rgr.project;

import com.rgr.project.logic.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {
    public static void main(java.lang.String[] args) {
        SpringApplication.run(Application.class,args);

//        Scanner input = new Scanner(System.in);
//        Flower flower;
//
//
//        CustomBouquet customBouquet = new CustomBouquet();
//        Waiter waiter = new Waiter(customBouquet);
//        flower = new Flower(Flowers.LILLY, 30);
//
//        int n = 0;
//        while (n != 2){
//            String flowerStr = flower.getName().toString();
//            waiter.constructBouquet(flowerStr, flower.getPrice());
//            System.out.println("To continue type '1'");
//            System.out.println("To Stop type '2'");
//            n = input.nextInt();
//        }


//        System.out.println(flower.toString() + ";" + flower1.toString()+ ";" + flower2.toString());
    }
}
