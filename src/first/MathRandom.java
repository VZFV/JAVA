package first;

public class MathRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1;
		num1 = (int)(25 + Math.random()*26);
		System.out.println("The array size is " + num1);
		
		int[] arr = new int[num1];
		
		System.out.println("Elements randomly chosen are: ");
		for(int i = 0; i < arr.length;i++){
			arr[i] = (int)(100 + Math.random()*901);
			System.out.println(arr[i]);
		}	
		
		for(int j = 1; j<= 20; j++){
			int index = (int)(Math.random()*(arr.length));
			System.out.printf("The value of the array element at index %s is %s%n"
					, index, arr[index]);

		}		
	}
}
