package QueueCodeFiles;

//import java.util.Queue;

public class radixSort {
	public static final int RADIX = 10;
	public static void radixSort(int[] a, int first, 
			int last, int maxDigits){
		QueueInterface<Integer>[] buckets = new LinkedQueue[RADIX];
		//Queue<Integer>[] buckets = new Queue[RADIX];
		
		int bucket, i, index;
		
		for(bucket = 0; bucket<RADIX; bucket++)
			buckets[bucket] = new LinkedQueue<Integer>();
			//buckets[bucket] = new Queue<Integer>();
			int factor = 1;
			
			for(i = 1; i<= maxDigits; i++, factor *=RADIX){
				//for(bucket = 0;bucket<RADIX; bucket++)
					//buckets[bucket].clear();
				for(index = first; index <= last; index++){
					int ithDigit = (a[index]%(factor*RADIX))/factor;
					buckets[ithDigit].enqueue(a[index]);
				}// end for loop
			
			bucket = 0;
			
			for(index = first; index <= last; index++){
				while(buckets[bucket].isEmpty())
					bucket++;			
				a[index] = buckets[bucket].dequeue();												
			}
		}
	}

	public static void main(String args[]){
		int array[] = {6340, 1234, 291, 3, 6325, 68, 5227, 1638};
		
		System.out.println("The array is ");
		for(int i =0;i<array.length; i++){
			System.out.println(array[i] + " ");
		}
		
		radixSort(array, 0, array.length-1, 4);
		System.out.println("The sorted array is ");
		for(int i =0;i<array.length; i++){
			System.out.println(array[i] + " ");
		}
	}
}
