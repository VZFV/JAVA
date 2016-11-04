/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1014;

/**
 * Ch 10 Ex10.14
 * Feng Zhang
 * 7/10/2016
 */
public class PieceWorker extends Employee{
    private double wage;
    private int pieces;
    
    public PieceWorker(String firstName, String lastName, 
      String socialSecurityNumber, double wage, int pieces){
        super(firstName, lastName, socialSecurityNumber);
        if (wage < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");
        
        if (pieces < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Pieces must be >= 0.0");
        
        this.wage = wage;
        this.pieces = pieces;
    }
    
    public void setWage(double wage)
   {
        if (wage < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");

      this.wage = wage;
   } 
    
    public double getWage()
   {
      return wage;
   } 
    
    public void getPieces(int pieces){
        if (pieces < 0.0) // validate wage
         throw new IllegalArgumentException(
            "Pieces must be >= 0.0");
        
        this.pieces = pieces;
    }
    
    public int getPieces()
   {
      return pieces;
   }
    
    @Override
    public double earnings(){
        return getWage() * getPieces();
    }
    
    @Override
    public String toString()                                              
   {                                                                     
      return String.format("%s%n%s: $%.2f; %s: %d", super.toString(), 
              "wage per piece", getWage(), "pieces produced", getPieces());
   }
}
