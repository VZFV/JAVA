/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Ch 7 Ex7.17
 * Feng Zhang
 * 7/3/2016
 */
import java.security.SecureRandom;
public class Ex717 {
    public static void main(String[] args)
   {
      SecureRandom randomNumbers = new SecureRandom();
      int[] frequency = new int[13]; 

      for (int roll = 1; roll <= 36000; roll++) 
         ++frequency[2 + randomNumbers.nextInt(6) + randomNumbers.nextInt(6)];  

      System.out.printf("%s%12s%15s%n", "Face", "Frequency", "Percentage");
   
      for (int face = 2; face < frequency.length; face++){
         System.out.printf("%4d%12d%15d%n", face, frequency[face], frequency[face]/360);
      }
      System.out.println("The frequency of value 7 has highest percentage.");
   } 
}
