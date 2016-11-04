/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex312;

/**
 * Ch 3 Ex3.12
 * Feng Zhang
 * 6/23/2016
 */
public class Invoice {
   private String partNumber; 
   private String partDescription;
   private int quantity;
   private double pricePerItem;

   // four-argument constructor
   public Invoice( String part, String description, int count, 
      double price )
   {
      partNumber = part;
      //TODO  initialize other instance variables
      partDescription = description;
      quantity = count;
      pricePerItem = price;	  	  
	  
   } // end four-argument Invoice constructor

   // set part number
   public void setPartNumber( String part )
   {
      partNumber = part;  
   } // end method setPartNumber

   // get part number
   public String getPartNumber()
   {
      return partNumber;
   } // end method getPartNumber

   // TODO setPartDescription
   public void setPartDescription( String description )
  {
      partDescription = description;
  }
   // TODO getPartDescription
   public String getPartDescription()
   {
       return partDescription;
   }
   // TODO setQuantity
   public void setQuantity(int count)
  {
       quantity = count;
  }
   // TODO  getQuantity
   public int getQuantity()
   {    
       return quantity;
   }
   // TODO setPricePerItem
   public void setPricePerItem(double price)
   {
       pricePerItem = price;
   }
    
   // TODO getPricePerItem
   public double getPricePerItem()
   {
       return pricePerItem;
   }
   // TODO invoiceAmount
   public double getInvoiceAmount()
   {
      double calculateTotalAmount;
      calculateTotalAmount = quantity * pricePerItem;
      return calculateTotalAmount;
   }

   // TODO optional printInvoice
    
}
