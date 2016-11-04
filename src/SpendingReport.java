/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Midterm Question3
 * Feng Zhang
 * 8/8/2016
 */
import java.util.Scanner;
public class SpendingReport {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double array[] = new double[7];
        double total = 0;
        double average = 0;
        
        for ( int i = 0; i< array.length;i++ ){
            array[i] = input.nextDouble();  
            System.out.printf("Enter spending day %s ($): %s\n", i + 1, array[i]);
            total += array[i];
        }
        
        average = total/7;
        int j = 0;
        int k = 0;
        for ( int i = 0; i<array.length; i++){
            if ( array[i] > average){
                j++;
            }
            if ( array[i] > k){
                k = i;
            }
        }
        
        System.out.printf("Total spending: $%s\n", total);
        System.out.printf("Average: $%.2f/day\n", average);
        System.out.printf("Number of days above average spending: %s\n", j);
        
        switch(k){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Highest spending day: Tuesday");
                break;
            case 3:
                System.out.println("Highest spending day: Wednesday");
                break;
            case 4:
                System.out.println("Highest spending day: Thursday");
                break; 
            case 5:
                System.out.println("Highest spending day: Friday");
                break; 
            case 6:
                System.out.println("Highest spending day: Saturday");
                break;
            case 7:
                System.out.println("Highest spending day: Sunday");
                break;
    }
    } 
}
