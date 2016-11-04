/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex84;

/**
 * Ch 8 Ex8.4
 * Feng Zhang
 * 7/8/2016
 */
public class Rectangle {
    private double length;
    private double width;
    
    public Rectangle(double length, double width){
        if(length < 0.0 || length > 20.0){
            throw new IllegalArgumentException("length must be 0.0-20.0"); 
        }
        if(width < 0.0 || width > 20.0){
            throw new IllegalArgumentException("width must be 0.0-20.0"); 
        }
        this.length = length;
        this.width = width;
}
    public void setLength(double length){
        if(length < 0.0 || length > 20.0){
            throw new IllegalArgumentException("length must be 0.0-20.0"); 
        }
        this.length = length;
    }
    
    public void setWidth(double width){
        if(width < 0.0 || width > 20.0){
            throw new IllegalArgumentException("width must be 0.0-20.0"); 
        }
        this.width = width;
    }
    
    public double getLength(){
         return length;
     }

     public double getWidth(){
         return width;
     }

     public double Perimeter(){
         return 2 * length + 2 * width;
     }

     public double area(){
         return length * width;
     }
     
     public String toRectangleString(){
        return ("Length: "+ length + "\n"+ "Width: "+ width + "\n"+ "Perimiter: "+ Perimeter()
                + "\n"+ "Area: "+ area());
}
}
