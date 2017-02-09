package first;

public class Exercise12_2 {
	
	public static void main( String [] args )
	{
		
		int k, 		// index for array
		arraySize = (int)(Math.random()*15001) + 5000; // size of array (changes)
		long startTime, stopTime; // for timing
		double elapsedTime = 0; // for timing
		
		Integer [] arrayOfInts1 = null;  // for dynamic array
		Integer [] arrayOfInts2 = null;
		Integer [] arrayOfInts3 = null;
		
			// allocate array and stuff will values
			arrayOfInts1 = new Integer[arraySize];
			arrayOfInts2 = new Integer[arraySize];
			arrayOfInts3 = new Integer[arraySize];
		
			for (k = 0; k < arraySize; k++)
			{   // THIS USES AUTO-BOXING, SO YOU NEED AT LEAST Java 6 FOR THIS
             arrayOfInts1[k] = arrayOfInts2[k] = arrayOfInts3[k] =(int)(Math.random()*arraySize);
			}
			startTime = System.nanoTime();		// start timing shell sort----------
			// sort using a shell sort
			SortMethods.shellSort(arrayOfInts1, arraySize);
        	stopTime = System.nanoTime();		// stop timing ---------------------
        	elapsedTime =(double)(stopTime - startTime)/1000000.0;
        	System.out.println("\nN: " + arraySize + " Shell Sort Time: "
        			+ elapsedTime + " milliseconds.");
        	
        	startTime = System.nanoTime();		// start timing shell sort----------
			// sort using a shell sort
			SortMethods.shellSort1(arrayOfInts2, arraySize);
        	stopTime = System.nanoTime();		// stop timing ---------------------
        	elapsedTime =(double)(stopTime - startTime)/1000000.0;
        	System.out.println("\nN: " + arraySize + " Shell Sort Time: "
        			+ elapsedTime + " milliseconds.");
        	
        	startTime = System.nanoTime();		// start timing shell sort----------
			// sort using a shell sort
			SortMethods.shellSort2(arrayOfInts3, arraySize);
        	stopTime = System.nanoTime();		// stop timing ---------------------
        	elapsedTime =(double)(stopTime - startTime)/1000000.0;
        	System.out.println("\nN: " + arraySize + " Shell Sort Time: "
        			+ elapsedTime + " milliseconds.");
		
	}// end main
	
	public static class SortMethods {
		// SHELL SORT
		public static <T extends Comparable<? super T>>
		       void shellSort(T[] a, int n)
		{
			shellSort(a, 0, n - 1);
		} // end shellSort

		/** Sorts equally spaced elements of an array into
		    ascending order.
		    @param a      An array of Comparable objects.
		    @param first  An integer >= 0 that is the index of the first
		                  array element to consider.
		    @param last   An integer >= first and < a.length that is the
		                  index of the last array element to consider.
		    @param space  The difference between the indices of the
		                  elements to sort. */
	   public static <T extends Comparable<? super T>>
	          void shellSort(T[] a, int first, int last)
	   {
	      int n = last - first + 1; // Number of array entries

		  for (int space = n/2; space > 0; space = space/2)
	      {
	         for (int begin = first; begin < first + space; begin++)
	         {
	            incrementalInsertionSort(a, begin, last, space);
	         } // end for
	        
	      } // end outer for
	   } // end shellSort
	   
	   // SHELL SORT
			public static <T extends Comparable<? super T>>
			       void shellSort1(T[] a, int n)
			{
				shellSort(a, 0, n - 1);
			} // end shellSort

			/** Sorts equally spaced elements of an array into
			    ascending order.
			    @param a      An array of Comparable objects.
			    @param first  An integer >= 0 that is the index of the first
			                  array element to consider.
			    @param last   An integer >= first and < a.length that is the
			                  index of the last array element to consider.
			    @param space  The difference between the indices of the
			                  elements to sort. */
		   public static <T extends Comparable<? super T>>
		          void shellSort1(T[] a, int first, int last)
		   {
		      int n = last - first + 1; // Number of array entries
		  
			  for (int space = n/2-1; space > 0; space = (space+1)/2-1)
		      {
		         for (int begin = first; begin < first + space; begin++)
		         {
		            incrementalInsertionSort(a, begin, last, space);
		         } // end for
		        
		      } // end outer for
		   } // end shellSort	 
		   
		// SHELL SORT
			public static <T extends Comparable<? super T>>
			       void shellSort2(T[] a, int n)
			{
				shellSort(a, 0, n - 1);
			} // end shellSort

			/** Sorts equally spaced elements of an array into
			    ascending order.
			    @param a      An array of Comparable objects.
			    @param first  An integer >= 0 that is the index of the first
			                  array element to consider.
			    @param last   An integer >= first and < a.length that is the
			                  index of the last array element to consider.
			    @param space  The difference between the indices of the
			                  elements to sort. */
		   public static <T extends Comparable<? super T>>
		          void shellSort2(T[] a, int first, int last)
		   {
		      int n = last - first + 1; // Number of array entries

			  for (int space = n/2+1; space > 0; space = (space-1)/2+1)
		      {
		         for (int begin = first; begin < first + space; begin++)
		         {
		            incrementalInsertionSort(a, begin, last, space);
		         } // end for
		        
		      } // end outer for
		   } // end shellSort
	   
	   
		
	   
		
	   //  Sorts equally spaced elements of an array into ascending order.
	   //  Parameters:
	   //     a      An array of Comparable objects.
	   //     first  The integer index of the first array entry to
	   //            consider; first >= 0 and < a.length.
	   //     last   The integer index of the last array entry to
	   //            consider; last >= first and < a.length.
	   //     space  The difference between the indices of the
	   //            entries to sort.
	   private static <T extends Comparable<? super T>>
	           void incrementalInsertionSort(T[] a, int first, int last, int space)
	   {
	      int unsorted, index;

	      for (unsorted = first + space; unsorted <= last; 
	          unsorted = unsorted + space)
	      {
	         T nextToInsert = a[unsorted];
	         index = unsorted - space;
	         while ((index >= first) && (nextToInsert.compareTo(a[index]) < 0))
	         {
	            a[index + space] = a[index]; 
	            index = index - space;
	         } // end while

	         a[index + space] = nextToInsert; 
	      } // end for
	   } // end incrementalInsertionSort
			   		   
	} // end SortMethods class
}
/*
 * 
N: 18808 Shell Sort Time: 28.443214 milliseconds.

N: 18808 Shell Sort Time: 12.596128 milliseconds.

N: 18808 Shell Sort Time: 4.702017 milliseconds.

 */
