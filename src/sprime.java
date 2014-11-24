/*
 ID: darshan4
 LANG: JAVA
 TASK: sprime
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class sprime {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		int n = Integer.parseInt(f.readLine());
		f.close();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l1.add(2);
		l1.add(3);
		l1.add(5);
		l1.add(7);
		for(int i = 1; i < n; i++){
			for(int j = 0; j < l1.size(); j++){
				for(int k = 0; k <=9; k++){
					int x = Integer.parseInt("" + l1.get(j) + k);
					if(checkPrime(x)){
						l2.add(x);
					}
				}
			}
			l1 = l2;
			l2 = new ArrayList<Integer>();
		}
		Collections.sort(l1);
		for(int i = 0; i < l1.size(); i++){
			out.println(l1.get(i));
		}
		out.close();
		System.exit(0);
	}

	private static boolean checkPrime(int x) {
		for(int i = 2; i <= Math.sqrt(x); i++){
			if((x % i) == 0){
				return false;
			}
		}
		return true;
	}

}
