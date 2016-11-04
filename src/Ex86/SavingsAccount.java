/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex86;

/**
 * Ch 8 Ex8.6
 * Feng Zhang
 * 7/8/2016
 */
public class SavingsAccount {
    private double savingsbalance;
    private static double annualInterestRate;
    
    public SavingsAccount(double balance){
        savingsbalance = balance;
    }
    
    public void calculateMonthlyInterest(){
        savingsbalance += savingsbalance * (annualInterestRate/12.0);
    }
    
    public static void modifyInterestRate(double newValue){
        annualInterestRate = (newValue >= 0 && newValue <= 1.0?newValue: 0.04);
    }
    
    public String toString(){
        return String.format("$%.2f", savingsbalance);
    }
}
