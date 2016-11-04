package first;

public class Exercise6_2
{
	public static int MIN_SIZE = 5000;
	public static int MAX_SIZE = 40000;
	// PUT BUBBLE SORT AND SELECTION SORT HERE
	public static void bubbleSort(Integer data[]) {  
        for (int i = 0; i < data.length -1; i++) {  
            for (int j = 0; j < data.length - i - 1; j++) {  
                if (data[j] > data[j + 1]) {  
                    int temp = data[j];  
                    data[j] = data[j + 1];  
                    data[j + 1] = temp;  
                }  
            }  
        }  
    }  
	
	public static void selectionSort(Integer data[]) {  
        int minVal;  
        int minIndex;  
        for (int i = 0; i < data.length - 1; i++) {  
            minVal = data[i];  
            minIndex = i;  
            for (int j = i + 1; j < data.length; j++) {  
                if (data[j] < minVal) {  
                    minVal = data[j];  
                    minIndex = j;  
                }  
            }  
            if (minVal != data[i] && minIndex != i) {  
                data[minIndex] = data[i];  
                data[i] = minVal;  
            }  
        }  
    }  

	// --------------- main ---------------
	public static void main( String [] args )
	{
		int k, 		// index for array
		arraySize; // size of array (changes)
		long startTime, stopTime; // for timing
		double elapsedTime = 0; // for timing
		Integer [] arrayOfInts1 = null;  // for dynamic array
		Integer [] arrayOfInts2 = null;  // copy of dynamic array elements
		for(arraySize = MIN_SIZE; arraySize <= MAX_SIZE; arraySize*=2)
		{
			// allocate array and stuff will values
			arrayOfInts1 = new Integer[arraySize];
			arrayOfInts2 = new Integer[arraySize];
			for (k = 0; k < arraySize; k++)
			{   // THIS USES AUTO-BOXING, SO YOU NEED AT LEAST Java 6 FOR THIS
             arrayOfInts1[k] = arrayOfInts2[k] = (int)(Math.random()*arraySize);
			}
			startTime = System.nanoTime();		// start timing bubble sort----------
			// sort using a bubble sort
         	bubbleSort(arrayOfInts1);
        	stopTime = System.nanoTime();		// stop timing ---------------------
        	elapsedTime =(double)(stopTime - startTime)/1000000.0;
        	System.out.println("\nN: " + arraySize + " Bubble Sort Time: "
        			+ elapsedTime + " milliseconds.");
        	startTime = System.nanoTime();		// start timing selection sort-------
        	// sort using a bubble sort
        	selectionSort(arrayOfInts2);
        	stopTime = System.nanoTime();		// stop timing ---------------------
        	elapsedTime =(double)(stopTime - startTime)/1000000.0;
        	System.out.println("\nN: " + arraySize + " Selection Sort Time: "
        			+ elapsedTime + " milliseconds.");
		}// end for
	}// end main
} // end class Exercise6_2


/**
Output:
N: 5000 Bubble Sort Time: 88.948938 milliseconds.

N: 5000 Selection Sort Time: 15.985778 milliseconds.

N: 10000 Bubble Sort Time: 340.494222 milliseconds.

N: 10000 Selection Sort Time: 40.762864 milliseconds.

N: 20000 Bubble Sort Time: 1689.829925 milliseconds.

N: 20000 Selection Sort Time: 164.234272 milliseconds.

N: 40000 Bubble Sort Time: 6167.469037 milliseconds.

N: 40000 Selection Sort Time: 776.971062 milliseconds.

Answer for questions:
1. At about 4.
2. Yes.
3. It will take longer time to sort a bigger size data. 
*/ 
