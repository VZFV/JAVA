/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1012;

/**
 * Ch 10 Ex10.12
 * Feng Zhang
 * 7/10/2016
 */
public abstract class Employee {
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private Date birthdate;

   // constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber, Date DateOfBirth)
   {
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;      
      birthdate = DateOfBirth;
   } 

   // return first name
   public String getFirstName()
   {
      return firstName;
   } 

   // return last name
   public String getLastName()
   {
      return lastName;
   } 

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } 
   
   public void setBirthdate(Date DateOfBirth)
   {
       birthdate = DateOfBirth;
   }
   
   public Date getBirthdate(){
       return birthdate;
   }

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format("%s %s%nsocial security number: %s%nbirth date: %s", 
         getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthdate());
   } 

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
    
}
