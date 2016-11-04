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
public class Employee {
    private String firstname;
    private String lastname;
    private double monthlySalary;
    
    public Employee(String name1, String name2, double salary)
    {
        firstname = name1;
        lastname = name2;
        monthlySalary = salary;
        
    }
    public void setFirstName(String name1)
    {
        firstname = name1;
    }
    public String getFirstName()
    {
        return firstname;
    }
    public void setLastName(String name2)
    {
        lastname = name2;
    }
    public String getLastName()
    {
        return lastname;
    }
    public void setMonthlySalary(double salary)
    {
        monthlySalary = salary;
    }
    public double getMonthlySalary()
    {
        return monthlySalary;
    }
    public double getyearlySalary()
    {
        double yearlySalary;
        yearlySalary = monthlySalary * 12;
        return yearlySalary;
    }
    public double getyearlySalaryRaise()
    {
        double yearlySalaryRaise;
        yearlySalaryRaise = monthlySalary * 12 * 1.1;
        return yearlySalaryRaise;
    }
                             
}
