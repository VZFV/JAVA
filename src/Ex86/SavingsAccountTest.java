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
public class SavingsAccountTest {
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);   
        
        SavingsAccount.modifyInterestRate(0.04);
        
        System.out.println("Monthly balances for one year at 0.04");
        System.out.println("Balance:");
        System.out.printf("%20s%10s\n", "saver1", "saver2");
        
        System.out.printf("%-10s%10s%10s\n", "Base", saver1.toString(), saver2.toString());
        
        for (int month = 1; month <=12; month++){
            String monthNumber = String.format("Month %d: ", month);
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("%-10s%10s%10s\n", monthNumber, saver1.toString(), saver2.toString());            
        }
        
        System.out.println("After  setting interest rate to 0.05");
        System.out.println("Balance:");
        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("%-10s%10s\n", "saver1", "saver2");
        System.out.printf("%-10s%10s\n", saver1.toString(), saver2.toString());
    }
}
