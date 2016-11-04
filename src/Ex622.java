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
public class Ex622 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(true){
        System.out.print("1. Fahrenheit to Celsius\n2. Celsius to Fahrenheit\n"
               + "3. Exit\n"+ "Choice: ");
        int choice = input.nextInt();
        if ( choice == 1){
            System.out.print("Enter temperature: ");
            int Fahrenheit = input.nextInt();
            int Celsius = calcCelsius(Fahrenheit);
            System.out.printf("%d Fahrenheit is %d Celsius\n\n", Fahrenheit, Celsius);
        }
        if ( choice == 2){
            System.out.print("Enter temperature: ");
            int Celsius = input.nextInt();
            int Fahrenheit = calcFahrenheit(Celsius);
            System.out.printf("%d Celsius is %d Fahrenheit\n\n", Celsius, Fahrenheit);
        }
        if ( choice == 3){
            break;
        }
}
    }   
        public static int calcCelsius(int Fahrenheit){
            int Cel;
            Cel =  (Fahrenheit - 32) * 5 / 9;
            return Cel;
        }
        public static int calcFahrenheit(int Celsius){
            int Fah;
            Fah = (9 / 5 * Celsius + 32);
            return Fah;
        }
}
