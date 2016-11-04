/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Ch 7 Ex7.29
 * Feng Zhang
 * 7/3/2016
 */
public class Ex729 {
    public static void main(String[] args){
        System.out.println("Fibonacci Series upto 20");
        int fib[] = new int[20];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i ++){
            fib[i] = fib[i -1] + fib[i - 2];
        }
        for (int i = 0; i < fib.length; i++){
        System.out.printf("%d ", fib[i]);
        }
    }
}
