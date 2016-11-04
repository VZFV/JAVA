/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Midterm Question2
 * Feng Zhang
 * 8/8/2016
 */
public class Discount {
    public static void main( String [] args ) {
        double price;
     
        System.out.println("Original Price  Final Price");
        for (price = 19.99; price <= 69.99; price +=10){
            System.out.printf("$%.2f          $%.2f\n", price, finalPrice(price));
            }
        }
    
    public static double finalPrice(double price){
        double finalPrice = 0;
        if (price > 0 && price < 30){
            finalPrice = price * (1 - 0.25);
        }
        
        if (price > 30 && price < 50){
            finalPrice = price * (1 - 0.25) - 5;
        }
        
        if (price > 50){
            finalPrice = price * (1 - 0.25) - 10;
        }
        return finalPrice;
    } 
}
    

