/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Midterm Question4
 * Feng Zhang
 * 8/8/2016
 */
import java.util.Scanner;
public class StudentTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        Student student = new Student(123456, "John Smith", 55.0);
        System.out.println("Student information:");
        System.out.println(student.toString());
        
        System.out.printf("\nEnter Current Semester Units: ");
        double m = input.nextDouble() + student.getTotalNumberOfUnits();
        
        student.setTotalNumberOfUnits(m);
        System.out.printf("\nUpdated Student information: \n");
        System.out.println(student.toAfterString());
    }
}
