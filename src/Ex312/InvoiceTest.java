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
public class InvoiceTest 
{
    public static void main( String[] args )
   {
      //create a new invoice called invoice1
      Invoice invoice1 = new Invoice("1234","Hammer",2,14.95);
 
      // display invoice1
      System.out.print("Original invoice information\n");
      System.out.printf("Part number: %s\n", invoice1.getPartNumber());
      System.out.printf("Description: %s\n", invoice1.getPartDescription());
      System.out.printf("Quantity: %s\n", invoice1.getQuantity());
      System.out.printf("Price: %s\n", invoice1.getPricePerItem());
      System.out.printf("Invoice amount: %.2f\n\n", invoice1.getInvoiceAmount());
  

      // change invoice1's data using set methods
      invoice1.setPartNumber("001234");
      invoice1.setPartDescription("Yello Hammer");
      invoice1.setQuantity(3);
      invoice1.setPricePerItem(19.49);
      // display invoice1 with new data
      System.out.print("Updated invoice information\n");
      System.out.printf("Part number: %s\n", invoice1.getPartNumber());
      System.out.printf("Description: %s\n", invoice1.getPartDescription());
      System.out.printf("Quantity: %s\n", invoice1.getQuantity());
      System.out.printf("Price: %s\n", invoice1.getPricePerItem());
      System.out.printf("Invoice amount: %.2f\n\n", invoice1.getInvoiceAmount());
      
      
      //create a new invoice called invoice2
      Invoice invoice2 = new Invoice("5678","PaintBrush",0,0);
      // display invoice2
      System.out.print("Original invoice information\n");
      System.out.printf("Part number: %s\n", invoice2.getPartNumber());
      System.out.printf("Description: %s\n", invoice2.getPartDescription());
      System.out.printf("Quantity: %s\n", invoice2.getQuantity());
      System.out.printf("Price: %s\n", invoice2.getPricePerItem());
      System.out.printf("Invoice amount: %.2f\n\n", invoice2.getInvoiceAmount());
      // change invoice2's data using set methods
      invoice2.setPartNumber("5678");
      invoice2.setPartDescription("PaintBrush");
      invoice2.setQuantity(3);
      invoice2.setPricePerItem(9.49);
      // display invoice2 with new data
      System.out.print("Updated invoice information\n");
      System.out.printf("Part number: %s\n", invoice2.getPartNumber());
      System.out.printf("Description: %s\n", invoice2.getPartDescription());
      System.out.printf("Quantity: %s\n", invoice2.getQuantity());
      System.out.printf("Price: %s\n", invoice2.getPricePerItem());
      System.out.printf("Invoice amount: %.2f\n\n", invoice2.getInvoiceAmount());
   } // end main
} // end class InvoiceTest
    