/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */
public class Ex524 {
    public static void main(String args[]){			
		for(int i=1;i<=9;i+=2){
			for(int x=9;x>i-1;x--){
				System.out.print(" ");
			}
			for(int star=1;star<=i;star++){
				System.out.print("* ");
			}
		       System.out.println();
		}
		for(int j=1;j<=7;j+=2){
				for(int x=1;x<j+3;x++){
					System.out.print(" ");
				}
				for(int star=7;star>=j;star--){
					System.out.print("* ");
				}
			System.out.println();
		}
    }
    
}
