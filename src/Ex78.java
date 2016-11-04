/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Ch 7 Ex7.8
 * Feng Zhang
 * 7/3/2016
 */
public class Ex78 {
    public static void main(String[] args){
        //a
        int[] arrayf = { 1, 2, 3, 4, 5, 6};
        System.out.printf("a) The value of element 6 of array f is %d\n\n", arrayf[5]);
        //b
        int[] arrayg = { 8, 8, 8, 8, 8};
        System.out.print("b) The five elements of one-dimensional integer array g:\n");
        for (int counter = 0; counter < arrayg.length; counter++){
           System.out.printf("g[%d] = %d\n", counter, arrayg[counter]);
        }
        //c
        double[] arrayc = new double[100];
        double total = 0;
        for (int i = 0; i < arrayc.length; i++){
            arrayc[i] = i + 1;
        }
        for (int i = 0; i < arrayc.length; i++){
            total += arrayc[i];
        }
        System.out.printf("\nc) The total of the 100 elements of floating-point array c is %.2f\n", total);
        //d
        int[] arraya = {6, 20, 38 ,51, 58, 88, 2, 77, 79, 68, 29};
        int[] arrayb = new int[34];
        System.out.println("\nThe 11-element array a:");
        for (int j = 0; j < arraya.length; j ++){
            arrayb[j] = arraya[j];
            System.out.printf("a[%d] = %d\n", j, arraya[j]);
        }
        System.out.println("\nThe array b after copying 1 1-element array a into the first portion of array b:");
        for (int k = 0; k < arrayb.length; k++){
            System.out.printf("b[%d] = %d\n", k, arrayb[k]);
        }
        //e
        double[] arrayw = new double[99];
        for (int i = 0; i < arrayw.length; i++){
            arrayw[i] = (double) Math.random()*(99);
        }
        double smallest = arrayw[0];
        double largest = arrayw[0];
        for (int i = 0; i< arrayw.length;i++){
        if (arrayw[i] > largest){
            largest = arrayw[i];
        }
        if (arrayw[i] < smallest){ 
            smallest = arrayw[i];
        }
     }
        System.out.printf("\ne) The largest value is %.2f", largest);
        System.out.printf("\nThe smallest value is %.2f\n", smallest);
    }
    
}
