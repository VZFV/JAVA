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
public class Ex620 {
    public static void main(String[] args){
        double radius;
        Scanner input = new Scanner(System.in);
        while(true){
        System.out.print("Enter the radius (negative to quit): ");
        radius = input.nextDouble();
        if(radius >= 0){
        double area = areaCalc(radius);
        System.out.printf("Area is %.6f\n\n", area);
        }else{
            return;
        }
    }
    }
    public static double areaCalc(double radius){
            double min;
            min = (radius * radius * Math.PI);
            return min;
        }
    }
    

