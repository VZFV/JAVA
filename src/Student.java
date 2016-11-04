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
public class Student {
    private int studentId;
    private String name;
    private double totalNumberOfUnits;
    private String standing;
    
    public Student(int studentId, String name, double totalNumberOfUnits){
        this.studentId = studentId;
        this.name = name;
        this.totalNumberOfUnits = totalNumberOfUnits;
    }
    
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    
    public int getStudentId(){
        return studentId;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setTotalNumberOfUnits(double totalNumberOfUnits){
        this.totalNumberOfUnits = totalNumberOfUnits;
    }
    
    public double getTotalNumberOfUnits(){
        return totalNumberOfUnits;
    }
    
    public String toString(){
        if (totalNumberOfUnits <= 30){
            standing = "freshan";
        }
        
        if (totalNumberOfUnits > 31 && totalNumberOfUnits <= 60 ){
            standing = "sophomore";
        }
        
        if (totalNumberOfUnits > 61 && totalNumberOfUnits <= 90 ){
            standing = "junior";
        }
        
        if (totalNumberOfUnits > 90){
            standing = "senior";
        }
        return ("Student ID: " + studentId + "\n" +"Student Name: " + name + "\n" + 
                "Total Number of Units Completed: "+ totalNumberOfUnits + "\n" + "Class Standing: " + standing);
    }
    
    public String toAfterString(){
        if (totalNumberOfUnits <= 30){
            standing = "freshan";
        }
        
        if (totalNumberOfUnits > 31 && totalNumberOfUnits <= 60 ){
            standing = "sophomore";
        }
        
        if (totalNumberOfUnits > 61 && totalNumberOfUnits <= 90 ){
            standing = "junior";
        }
        
        if (totalNumberOfUnits > 90){
            standing = "senior";
        }
        return ("Student Name: " + name + "\n"+ "Total Number of Units Completed: " +
                totalNumberOfUnits + "\n" + "Class Standing: " + standing);
    }
}
