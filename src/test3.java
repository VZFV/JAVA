import java.util.ArrayList;
import java.util.List;

public class test3{
	
	static int count;
	
	public static int countChar(String str, char c) {
		
		if(str.indexOf(c)!=-1){		
			count++;
			String temp = str.substring(str.indexOf(c)+1);
			countChar(temp, c);
		}
		return count;
	}
	
	static List<Integer> factorList = new ArrayList<Integer>();
	
	public static List<Integer> recursivePrimeFactors(int n) {
		
		if( n <= 0)
			return null;
		int factor = findAPrimeFactor(n);
	
		if(factor == 1)
			return factorList;
		factorList.add(factor);
		
		n /= factor;
		recursivePrimeFactors(n);
		return factorList;
	}

	/* Return a prime factor of n. */
	public static int findAPrimeFactor(int n) {
		for (int f = 2; f < n; f++)
			if (n % f == 0)
				return f;
		return n;
	}
	
	
	 static int n;
	public static void main(String[] args){
		recursivePrimeFactors(10);
		System.out.println(factorList);
		
		System.out.println(countChar("jahdafacahacdh", 'a'));
	}
}