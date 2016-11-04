/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex84;

/**
 * Ch 8 Ex8.4
 * Feng Zhang
 * 7/8/2016
 */
import java.util.Scanner;
public class RectangleTest {
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(1.0, 1.0);
        Scanner input = new Scanner(System.in);
        double length;
        double width;
        while(true){
            System.out.print("1. Set length"+ "\n2. set width"
               + "\n3. Exit"+ "\nChoice: ");
        int choice = input.nextInt();
        if ( choice == 1){
            System.out.print("Enter length: ");
            length = input.nextDouble();       
            rectangle.setLength(length);           
            System.out.println(rectangle.toRectangleString());
        }
        if ( choice == 2){
            System.out.print("Enter width: ");
            width = input.nextDouble();
            rectangle.setWidth(width);
            System.out.println(rectangle.toRectangleString());
        }
        if ( choice == 3){
            break;
        }
        }
    }
}
