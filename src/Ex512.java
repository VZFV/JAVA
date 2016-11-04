/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */
public class Ex512 {
    public static void main(String[] args)
    {
        int total =1;
        for (int i =1; i<16; i+=2){
            total = total*i;
        }
        System.out.println("Odd product is: "+total);
    }
}
