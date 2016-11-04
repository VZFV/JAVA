/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */
public class Ex625 {
       public static void main(String[] args){
           System.out.println("Prime numbers between 2 and 100 are:");
       for(int i = 1; i <= 100; i++)
       {
         if (isPrimeNumber(i))
         {
            System.out.println(i);
         }
       }
    }
    public static boolean isPrimeNumber(int i) {
        int factors = 0;
        int j = 1;

        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        return (factors == 2);
  }
}
   
