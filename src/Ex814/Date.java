/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex814;

/**
 * Ch 8 Ex814
 * Feng Zhang
 * 7/10/2016
 */
public class Date {
    private int month;
    private int day;
    private int year;
    private String mm;
    private int ddd;

    public Date(int month, int day, int year) {
        this.month = month;
	this.day = day;
        this.year = year;
    }

    public Date(String mm, int day, int year) {
	this.mm = mm;
	this.day = day;
	this.year = year;
    }
 
   
    double[] scores = new double[5];
     
    public Date(int ddd, int year) {
	this.ddd = ddd;
	this.year = year;
    }

    public int getMonth() {
	return month;
    }

    public void setMonth(int month) {
	this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
	this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
	this.year = year;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public String toStringFullMonth() {
	return mm + " " + day + ",  " + year;
    }

    public String toStringDayOfYear() {
	return ddd + " " + year;
    }
} 

   
