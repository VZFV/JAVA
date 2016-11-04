/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex313;

/**
 * Ch 3 Ex3.13
 * Feng Zhang
 * 6/23/2016
 */
public class EmployeeTest {
    public static void main(String[] args){
        Employee employee1 = new Employee("Bob","Jones",2875);
        Employee employee2 = new Employee("Susan","Baker",3150.75);
        
        System.out.printf("%s %s; Yearly Salary: %.2f\n", employee1.getFirstName()
        , employee1.getLastName(), employee1.getyearlySalary());
        System.out.printf("%s %s; Yearly Salary: %.2f\n\n", employee2.getFirstName()
        , employee2.getLastName(), employee2.getyearlySalary());
        
        System.out.println("Increasing employee salaries by 10%");
        System.out.printf("%s %s; Yearly Salary: %.2f\n", employee1.getFirstName()
        , employee1.getLastName(), employee1.getyearlySalaryRaise());
        System.out.printf("%s %s; Yearly Salary: %.2f\n\n", employee2.getFirstName()
        , employee2.getLastName(), employee2.getyearlySalaryRaise());
        
        
    }
    
}
