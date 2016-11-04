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
public class Ex226 {
    public static void main(String[] args){
        int number1;
        int number2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        number1 = input.nextInt();
        System.out.print("Enter second integer: ");
        number2 = input.nextInt();
        if (number1%number2==0){
            System.out.printf("%d is a multiple of %d.%n", number1, number2);
        }
        if (number1%number2 !=0){
            System.out.printf("%d is not a multiple of %d.%n", number1, number2);
        }
        
    }
    
}
