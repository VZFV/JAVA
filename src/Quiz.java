/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Midterm Question1
 * Feng Zhang
 * 8/8/2016
 */
import java.security.SecureRandom;
import java.util.Scanner;
public class Quiz {
    public static void main( String [] args ) {
        SecureRandom randomNumbers = new SecureRandom();
        Scanner input = new Scanner(System.in);
        int result,m,n;
        int i = 0;
        int j = 0;
        
        while(true){
            m = randomNumbers.nextInt(15)+ 1;
            n = randomNumbers.nextInt(15)+ 1;
            result = m * n;
            System.out.println("What is "+ m + "*" +  n + "(Enter answer or -1 to quit)");
            int answer = input.nextInt();
            if (answer != -1){
                if ( answer == result){
                    System.out.println("Correct");
                    i++;
                }else{
                    System.out.println("Incorrect");
                    j++;
                }
            }else{
                break;
            }
        }
        
        double x = (double)i*100/(i+j);
        System.out.printf("Total # of questions: "+ (i+j));
        System.out.printf("\nTotal # of correct: "+ i);
        System.out.printf("\nTotal # of correct: %.1f%%\n", x); 
    }
}
