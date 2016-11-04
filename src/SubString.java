/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */
public class SubString {
    public static void main(String[] args)
   {
      
      String letters = "abcdefghijklmabcdefghijklm";

      // test substring methods
      System.out.printf("Substring from index 20 to end is \"%s\"\n",
         letters.substring(20));
      System.out.printf("%s \"%s\"\n", 
         "Substring from index 3 up to, but not including 6 is",
         letters.substring(3, 6));
      
      int num = 15;
while (num > 0)
      num = num - 3;
System.out.println(num);

for (int i = 1; i <= 10; i++) {
  System.out.print(i + "  ");
  i++;
}

double area = 3.5;

System.out.print("area");

System.out.print(area);
   } 
}
