import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class PrintFactors {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		//read input
		System.out.println("Enter the number: ");
		int number = Integer.parseInt(f.readLine());
		int sqrt = (int) Math.sqrt(number);
		HashMap hm  = primeFac(number);
		int pfnum = 0;
		for(Object value : hm.values().toArray()){
			pfnum += (int) value;
		}
		// System.out.println(hashProd(hm) + " * 1");
		//printFac(hm);
		for(int i = 1; i <= pfnum; i ++){
			for(int j = 0; j < i-1; j ++){
				
			}
		}
		System.out.println(number + " * 1");
		for(int i = 2; i < number; i++){
			if(number % i == 0){
				printFac(number, i);
			}
		}
	
	      long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println("Total Execution Time: " + elapsedTime);
	}
	
	// Takes hashmap  with prime factor as key and # of times factor appears as value 
	// returns product of the prime factorization	
	
	
	private static int hashProd(HashMap<Integer, Integer> hm){
		int total = 1;
		for(Entry<Integer, Integer> entry : hm.entrySet()){
			total *= Math.pow(entry.getKey(), entry.getValue());
		}
		return total;
	}
//Takes hashmap  with prime factor as key and # of times factor appears as value and prints out

	private static void printFac(HashMap<Integer, Integer> hm){
		String s = "";
		for(Entry<Integer, Integer> entry: hm.entrySet()){
			for(int i = 0; i < entry.getValue(); i ++){
				s += (" * " + entry.getKey());
			}
		}
		
		System.out.println(s.substring(3));
		
	}
	
	// Given number and factor of number, prints the prime factorization of factor * number/factor
	private static void printFac(int number, int factor) {
		int first = number/factor;
		List<Integer> pFac = findFac(factor);
		if(!pFac.isEmpty()){
			pFac.remove(pFac.size()-1);
		}
		System.out.print(first);
		for(int j = 0; j < pFac.size(); j++){
			if(pFac.get(j) == 1){
				System.out.println();
				System.out.print(first);
			}
			else if(pFac.get(j) != -2){
				System.out.print(" * " + pFac.get(j));
			}
		}
		System.out.println();
	}
	
	//Finds all the factors of a number, really buggy
	private static List<Integer> findFac(int i){
		List<Integer> l = new ArrayList<Integer>();
		if(i != 1){
			for(int j = 2; j <= Math.sqrt(i); j++){
				if(i%j ==0){
					l.add(j);
					l.addAll(findFac(i/j));
				}
			}
			if(l.isEmpty()){
				l.add(i);
				l.add(1);
			}
		}
		else{
			l.add(1);
		}
		return l;
	}
	
	// Returns prime factorization of number
	private static HashMap<Integer,Integer> primeFac(int n){
		List<Integer> factors = new ArrayList<Integer>();
	    for (int i = 2; i <= n; i++) {
	      while (n % i == 0) {
	        factors.add(i);
	        n /= i;
	      }
	      if(n == 1){
	    	  break;
	      }
	    }
	    Object[] facs = factors.toArray();
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    int cur = 0;
	    int count = 0;
	    for(int i = 0; i < facs.length; i ++){
	    	if((int)facs[i] != cur){
	    		hm.put(cur, count);
	    		cur = (int) facs[i];
	    		count = 1;
	    	}
	    	else{
	    		count ++;
	    	}
	    }	 
	    hm.put(cur, count);
	    hm.remove(0);
	    return hm;
	}

}
