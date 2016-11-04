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
public class Ex216 {
    public static void main(String[] args)
   {
      // create a Scanner to obtain input from the command window
      Scanner input = new Scanner(System.in);

      int number1; // first number to add
      int number2; // second number to add

      System.out.print("Enter first integer: "); // prompt 
      number1 = input.nextInt(); // read first number from user

      System.out.print("Enter second integer: "); // prompt 
      number2 = input.nextInt(); // read second number from user
      
      if (number1>number2){
          System.out.printf("%d is larger\n", number1);
                  }
      
      if (number1==number2){
          System.out.printf("These number are equal\n");
      }
   } // end method main
} // end class Addition
    

