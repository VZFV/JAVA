/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */
import java.util.Scanner;
public class Ex417 {
    public static void main(String[] args){
        int miles,gallons = 0;
        double tankful = 0, totalmiles = 0,totalgallons = 0;
         Scanner user = new Scanner(System.in);
          
          while (true){
              System.out.print("Enter miles (-1 to quit): ");
              miles = user.nextInt();
              totalmiles += miles;
              if(miles != -1){
                System.out.print("Enter gallons: ");
                gallons = user.nextInt();
                totalgallons += gallons;
                Double MPG = totalmiles/totalgallons;
                System.out.printf("MPG this tankful: %.2f\n", tankful= miles/gallons);
                System.out.printf("Total MPG: %.2f\n", MPG); 
              }else{
                  System.exit(-1);
              }
          }
    }
    }

