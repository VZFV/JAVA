/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */
public class test {
    public static void main(String[] args) {
	double[] arrayw = new double[99];
        double smallest = arrayw[0];
        double largest = arrayw[0];
        for (int i = 0; i < arrayw.length; i++){
            arrayw[i] = (double) Math.random()*(90 -19);
        }
         System.out.println(arrayw[0]);
        for (int i = 0; i< arrayw.length;i++){
        if (arrayw[i] > largest){
            largest = arrayw[i];
        }
        if (arrayw[i] < smallest){
            smallest = arrayw[i];
        }
     }
        System.out.printf("The largest value is %.2f", largest);
        System.out.printf("\nThe smallest value is %.2f\n", smallest);
    }
}


